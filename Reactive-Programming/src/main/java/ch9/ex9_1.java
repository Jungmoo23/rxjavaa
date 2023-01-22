package ch9;

import java.util.*;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ex9_1 {

	// 버퍼 연산자는 지정된 배출을 먼저 수집하는 데 사용됩니다.
	// 한 번에 하나의 항목을 내보내는 대신 컬렉션 유형으로 
	/*
	 * 사용하는 방법
	 * 버퍼 사이즈 크기
	 * 버퍼 시간 범위를 버퍼에 전달(최대 버퍼 크기 지정된 시간 간격으로 방출을 버퍼링합니다)
	 * */
	
	
	public static void main(String[] args) throws InterruptedException{
		
		Observable.range(1,30)
		.filter(e -> e%2 ==0 && e!=2)
		//.buffer(4, HashSet :: new )
		.buffer(5)
		//.filter(e -> e % 2 ==0)
		.subscribe(System.out::println);
		
//		Observable.interval(500, TimeUnit.MILLISECONDS)
//		.buffer(1,TimeUnit.SECONDS,2)
//		.subscribe(System.out::println);
//		
//		Thread.sleep(8000);
		
		

		
		
		
		

	}

}
