package ch10;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ch10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Flowable.range(1,1000000)
		.map(e ->{
			System.out.println("Produced item is : e:: "+ e + " : "+Thread.currentThread().getName());
			return e;
		})
		.subscribeOn(Schedulers.io())
//		.subscribe(e -> {
//			sleep(100L);
//			System.out.println("Consumed item is : e:: "+ e + " : "+Thread.currentThread().getName());
//		});
		.subscribe(new Subscriber<Integer>() {
			Subscription s;
			AtomicInteger cnt = new AtomicInteger(0);

			@Override
			public void onSubscribe(Subscription s) {
				// TODO Auto-generated method stub
				this.s = s;
				System.out.println("Asking for 20 items");
				s.request(20);
				
			}

			@Override
			public void onNext(Integer t) {
				// TODO Auto-generated method stub
				
				System.out.println("The subscriber consumed: "+t);
				
				if(cnt.getAndIncrement() % 20 ==0) {
					System.out.println("Asking for 20 next items");
					s.request(20);
				}
				sleep(400L);
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
		});
		
		sleep(10000000L);

	}

	private static void sleep(Long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
