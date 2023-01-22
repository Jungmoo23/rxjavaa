package ch6_3;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Amn {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS)
				.map(e -> "src1:: "+e);
		
		Observable<String> src2 = Observable.interval(10, TimeUnit.MILLISECONDS)
			
				.map(e -> "src2:: "+e);

		
		Observable.amb(Arrays.asList(src1,src2))
		.subscribe(System.out::println);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
