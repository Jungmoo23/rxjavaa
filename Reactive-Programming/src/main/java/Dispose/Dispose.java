package Dispose;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Dispose {

	
	private static final CompositeDisposable disp = new CompositeDisposable();
	
	public static void main(String[] args) throws InterruptedException {
		
		Observable<Long> src=Observable.interval(1, TimeUnit.SECONDS);
		
		/*Disposable d=src.subscribe(s -> System.out.println("옵저버 1:: "+s)).dispose();*/  
		
		
//		src.subscribe(new Observer<Long>() {
//
//			private Disposable d;
//			@Override
//			public void onSubscribe(@NonNull Disposable d) {
//				// TODO Auto-generated method stub
//				this.d =d ;
//			}
//
//			@Override
//			public void onNext(@NonNull Long t) {
//				System.out.println("옵저버 1:: "+t);
//				
//			}
//
//			@Override
//			public void onError(@NonNull Throwable e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onComplete() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		
		
		Disposable dip =src.subscribe(s -> System.out.println("옵저버 1:: "+s));
		Disposable dip2 =src.subscribe(s -> System.out.println("옵저버 2:: "+s));
		
		
		//src.subscribe(s -> System.out.println("옵저버 1:: "+s)).dispose();
		
		Thread.sleep(5000);
		disp.addAll(dip,dip2);
		disp.dispose();
//		d.dispose();
		
		//src.subscribe(s -> System.out.println("옵저버 2:: "+s));
		
		Thread.sleep(10000);


	}

}
