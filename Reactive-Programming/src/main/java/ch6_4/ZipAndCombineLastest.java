package ch6_4;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ZipAndCombineLastest {

	public static void main(String[] args) throws InterruptedException {
	
		Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS);
		
		Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);
//		
//		Observable.zip(src1,src2,(e1,e2) -> "source1:: "+e1 + "source2:: "+ e2)
//		.subscribe(System.out::println);
		
		Observable.combineLatest(src1,src2,(e1,e2) -> "source1:: "+e1 + "source2:: "+ e2)
		.subscribe(System.out::println);
		
		Thread.sleep(20000);
	
		
				

	}

}
