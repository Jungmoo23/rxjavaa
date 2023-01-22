package ex7_5;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class publishSubject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.
		//Subject<String> sub  = PublishSubject.create();
		
		//2. ReplaySubject
		// Subject<String> sub  = ReplaySubject.create();
		
		//3. BehaviorSubject 동작 주제. 주제 구현은 가장 많이 방출하는 데 사용 됨. 최신 것 부터 가
		// Subject<String> sub  = BehaviorSubject.create();
		
		//4. AsyncSubject 소스의 마지막 값만 내보냄. onComlaote를 안쓰면 마지막 값을 출력이 안되어 무한으로 관찰을 함.
		//Subject<String> sub  = AsyncSubject.create();
		
		//5. UncastSubject 구독자 한명만 됨.
		Subject<String> sub  =UnicastSubject.create();
		
		sub.subscribe(e -> System.out.println("옵저버1:: "+	e));
		
		sub.onNext("a");
		sub.onNext("b");
		sub.onNext("c");
		
		sub.subscribe(e -> System.out.println("옵저버2:: "+	e));
		
		sub.onNext("d");
		sub.onNext("e");
		sub.onComplete();
		
		
		
		

	}

}
