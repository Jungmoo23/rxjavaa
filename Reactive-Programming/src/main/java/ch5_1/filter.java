package ch5_1;

import io.reactivex.rxjava3.core.Observable;

public class filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable.just(1,2,3,4)
		.filter(e -> e%2==0)
		.toSortedList((i1,i2)-> -i1.compareTo(i2)	)
		.subscribe(System.out::println);
	
	}

}
