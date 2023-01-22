package ch9;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ex9_2 {

	public static void main(String[] args) {
		Observable<Integer> ob = Observable.create(
				e ->
				{
					e.onNext(1);
					Thread.sleep(200);
					
					e.onNext(2);
					Thread.sleep(100);
					
					e.onNext(3);
					Thread.sleep(4100);
					
					e.onNext(4);
					Thread.sleep(700);
					
					e.onNext(5);
					Thread.sleep(900);
					
					e.onNext(6);
					Thread.sleep(300);
					
					e.onNext(7);
				//	Thread.sleep(400);
					
					e.onComplete();
				});
		
		
//		ob.throttleFirst(1000, TimeUnit.MILLISECONDS)
//		.subscribe(
//				item -> System.out.println("Item:: "+item),
//				Throwable::printStackTrace,
//				()->System.out.println("완")
//				
//				);
		
//		ob.sample(1000, TimeUnit.MILLISECONDS)
//		.subscribe(
//				item -> System.out.println("Item:: "+item),
//				Throwable::printStackTrace,
//				()->System.out.println("완")
//				
//				);
		
		ob.debounce(1000, TimeUnit.MILLISECONDS)
		.subscribe(
				item -> System.out.println("Item:: "+item),
				Throwable::printStackTrace,
				()->System.out.println("완")
				
				);
		

	}

}
