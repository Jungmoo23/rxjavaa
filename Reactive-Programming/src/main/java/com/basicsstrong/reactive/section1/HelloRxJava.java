package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Observable<String> source = Observable.create(
//				e -> {
//					e.onNext("Hello");
//					e.onNext("RxJava");
//				}
//			
//				);
//		
//		
//		source.subscribe(e-> System.out.println(e));
//		source.subscribe(e-> System.out.println("Observer2:: "+e));
		
		String num ="";
		for(int i=0; i<=100; i++) {
			
			if(i % 5 == 0 && i !=0) {
				num+=i;
				System.out.println("["+num+"]");
				num="";
			}
			num+= i+" ";
			
		}
		
		Observable.range(1,100)
		.buffer(5,5)
		.subscribe(System.out::println);
		
		
	}
}
	


