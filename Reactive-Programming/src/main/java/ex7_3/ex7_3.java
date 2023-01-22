package ex7_3;

import org.reactivestreams.Publisher;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class ex7_3 {

	public static void main(String[] args) throws InterruptedException {
		
//		Observable<Integer>src1 = Observable.just(1,2,3,4,5);
//		Observable<Integer>src2 = Observable.just(10,20,30,40,50);
		
		Observable<Integer>src1 = Observable.just(1,2,3,4,5)
				.subscribeOn(Schedulers.computation());
		Observable<Integer>src2 = Observable.just(10,20,30,40,50)
				.subscribeOn(Schedulers.computation());
		
		
		Subject<Integer> sub  = PublishSubject.create();
		
		sub.filter(e -> e %2 ==0)
		.subscribe(e -> System.out.println("Subject :: "+ e))
		;
		
//		src1.subscribe(e -> System.out.println("옵저버 1:: "+e));
//		src2.subscribe(e -> System.out.println("옵저버 2:: "+e));
		
		src1.subscribe(sub);
		src2.subscribe(sub);
		
		
		Thread.sleep(9000);

		
		
	}

}
