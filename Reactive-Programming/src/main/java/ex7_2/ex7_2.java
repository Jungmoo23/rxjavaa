package ex7_2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ex7_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
				.replay()
				.autoConnect();
		
		src.subscribe(e -> System.out.println("옵저버 1:: "+e));
		
		Thread.sleep(5000);
		
		src.subscribe(e -> System.out.println("옵저버 2:: "+e));
		
		
		Thread.sleep(5000);
		
		
	}

}
