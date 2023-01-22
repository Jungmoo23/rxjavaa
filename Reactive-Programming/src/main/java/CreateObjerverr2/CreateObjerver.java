package CreateObjerverr2;

import io.reactivex.rxjava3.core.Observable;

public class CreateObjerver {

	public static void main(String[] args) {
		Observable<String> source = Observable.just("kim","Lee","guk");
		source.subscribe(s -> System.out.println(s));
		
	}

}
