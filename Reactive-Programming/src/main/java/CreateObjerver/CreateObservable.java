package CreateObjerver;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class CreateObservable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> source  = Observable.create(
			e->{
				e.onNext(10);
				e.onNext(11);
				e.onNext(12);
				e.onComplete();
			}
		);
		
		source.subscribe(System.out::println);
		
		//just
		
		Observable<Integer> just  = Observable.just(1,2,3);
		just.subscribe(System.out::println);
		
		//fromIterable
		
		ArrayList<String> list = new ArrayList();
		list.add("국정무");
		list.add("jung moo");
		
		Observable<String> fromIterable = Observable.fromIterable(list);
		fromIterable.subscribe(System.out::println);
		
		//range
		
		Observable<Integer> rangee = Observable.range(1, 10);
		rangee.subscribe(s -> System.out.println(3*s));
		
		
		//Interval
		Observable<Long> interval = Observable.interval(1L, TimeUnit.SECONDS)
				.take(5);
		interval.subscribe(s -> System.out.println("안녕"+ s));
		int count = 0 ;
		while(count <10) {
			try {
				Thread.sleep(1000);
				count++;
				System.out.println("cnt:: "+count);
			}catch(Exception t) {
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
