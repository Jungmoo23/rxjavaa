package ex7_4;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class ex7_4 {

	public static void main(String[] args) {
//		PublishSubject<String> sub = PublishSubject.create();
//		
//		sub.subscribe(System.out::println);
//		sub.subscribe(e -> System.out.println("옵저버2::" +e));
//		
//		sub.onNext("Hi");
//		sub.onNext("BasicsString");
//		sub.onComplete();
//		sub.onNext("BasicsString");
		
		
		PublishSubject<String> sub = PublishSubject.create();
		Subject<String> serialized = sub.toSerialized();
		
		
		serialized.subscribe(System.out::println);
		serialized.subscribe(e -> System.out.println("옵저버2::" +e));
		
		serialized.onNext("Hi");
		serialized.onNext("BasicsString");
		serialized.onComplete();
		serialized.onNext("BasicsString");
		
		

	}

}
