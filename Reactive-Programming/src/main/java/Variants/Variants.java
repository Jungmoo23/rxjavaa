package Variants;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {

	public static void main(String[] args) {
		
		Observable<String> ob  = Observable.just("kim","Jemmy","boddy");
		
		Observable<String> ob1  = Observable.empty();
		
		ob1.first("name").subscribe(System.out::println);
		
		ob.first("Name").subscribe(System.out::println);
		
		
		Single.just("Name").subscribe(System.out::println);
		
		
		ob1.firstElement().subscribe(System.out::println, e -> e.printStackTrace(), ()-> System.out.println("end") );
		
		
		Completable completable = Completable.complete();
		
		completable.subscribe(() -> System.out.println("1"));

		Completable.fromRunnable(() -> System.out.println("ing....")).subscribe(()->System.out.println("das"));
		
		
	}

}
