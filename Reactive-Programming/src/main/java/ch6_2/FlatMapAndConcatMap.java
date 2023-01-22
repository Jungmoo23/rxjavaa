package ch6_2;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;

import java.util.*;

public class FlatMapAndConcatMap {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Hello");
		list.add("Reative");
		list.add("Programming");

//		Observable.fromIterable(list)
//		.flatMap(e -> Observable.fromArray(e.split("")))
//		.subscribe(System.out::println);
		
		Observable.fromIterable(list)
		.concatMap(e -> Observable.fromArray(e.split("")))
		.subscribe(System.out::println);
		
	}

}
