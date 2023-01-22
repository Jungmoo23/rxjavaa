package ch5_3;

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
		obs.filter(e -> e.getRatting()>4.0)
		.sorted((e1,e2) -> 
		Double.compare(e2.getRatting(),e1.getRatting()))
		.map(e -> e.getName())
		.take(4)
		.toList()
		
		.subscribe(e -> System.out.println(e));
		
	
		List<Integer> expenses = new ArrayList();
		expenses.add(789);
		expenses.add(890);
		expenses.add(3400);
		expenses.add(1030);
		expenses.add(999);
		expenses.add(234);
		expenses.add(129);
		expenses.add(340);
		expenses.add(300);
		expenses.add(500);
		expenses.add(200);
		
		
		Observable.fromIterable(expenses).scan((a,b)->a+b)
		.subscribe( a -> System.out.println(
				a
				) );
		
	}

}
