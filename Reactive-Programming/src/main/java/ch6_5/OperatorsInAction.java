package ch6_5;

import java.util.*;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable<Empoyee> obs=Observable.just(
				new Empoyee(101,"Alexa",60000,4.0),
				new Empoyee(123,"Dhwanit",60000,4.7),
				new Empoyee(236,"Mike",60000,4.0),
				new Empoyee(155,"Ella",60000,3.4),
				new Empoyee(443,"George",60000,3.6),
				new Empoyee(127,"Shreeja",60000,4.5),
				new Empoyee(509,"Daniel",60000,4.0),
				new Empoyee(344,"Lucy",60000,4.7),
				new Empoyee(509,"Harry",60000,4.3),
				new Empoyee(344,"Emma",60000,3.7)
				);
		obs.toSortedList((e1,e2)-> Double.compare(e1.getRatting(), e2.getRatting()))
		
		.subscribe( e -> e.forEach(e2 -> System.out.println(e2 +" 메")) );
		
		obs
		.groupBy(e->e.getRatting())
		.flatMapSingle(e ->e.toMultimap(key -> e.getKey(), emp -> emp.getName()))
		.subscribe(e -> System.out.println("result:: "+e));
		
		//obs.subscribe(e -> System.out.println("result:: "+e));
		
	}

}
