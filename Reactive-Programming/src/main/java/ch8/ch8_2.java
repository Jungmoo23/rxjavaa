package ch8;

import java.io.File;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/*
 * 스케줄러 
 * 1 . 컴퓨터 스케줄러:: 스케줄 computation
 *      -> 스레드 수와 프로세스의 수가 같음
 *  2. io 스케줄
 *  
 *  3. new 스케줄
 * 
 * 4 single 스케줄
 * 
 * 5. 트램폴린 스케줄링
 * 
 * 6. scheduler.from()
 * */

public class ch8_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		String[] file = new File("/Users/jm").list();
		
//		if(file.length<0) {
//			System.out.println("없음");
//		}
//		else {
//			for(File str : file) {
//				System.out.println("file name is "+str);
//			}
//		}
		
		
		Observable ob = Observable.fromArray(file)
				.filter(e -> !e.isEmpty())
				.map(put ->  put+"/국")
				.subscribeOn(Schedulers.io());
		
		ob.subscribe(out -> System.out.println("path:: /Users/jm"+out));
				
		
	
				
				
				
				
		
		
		
		
		
		
//		Observable<Integer>ob = Observable.just(1,2,3,4,5,6,7,8)
//				//.subscribeOn(Schedulers.computation());
//				//.subscribeOn(Schedulers.io());
//				//.subscribeOn(Schedulers.newThread());
//				.subscribeOn(Schedulers.single());
//		
//		ob.subscribe(e -> com());
//		//newThread 때문에 삽
////		Thread.sleep(5000);
//		ob.subscribe(e -> com());
//		ob.subscribe(e -> com());
//		ob.subscribe(e -> com());
//		ob.subscribe(e -> com());
//		ob.subscribe(e -> com());
//		ob.subscribe(e -> com());
//		ob.subscribe(e -> com());
		
		
		
		for(int i = 0; i <100 ; i++) {
			Thread.sleep(1000);
			System.out.println("right:: "+i);
		}
	}
	
//	public static void com() throws InterruptedException{
//		
//		Thread.sleep(1000);
//		System.out.println("Thread Time is:: "+Thread.currentThread().getName());
//		
//	}

}
