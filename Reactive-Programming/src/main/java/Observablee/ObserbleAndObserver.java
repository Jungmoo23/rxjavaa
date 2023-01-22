package Observablee;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObserbleAndObserver {

	public static void main(String[] args) {
		
		Observable<Integer> source = new ObservableCreate<Integer>(
				new ObservableOnSubscribe<Integer>() {
				public void subscribe(io.reactivex.rxjava3.core.ObservableEmitter<Integer> emitter) throws Throwable {
						try {
							emitter.onNext(10);
							emitter.onNext(11);
							emitter.onNext(12);
							emitter.onComplete();
							
						}catch(Throwable e) {
							emitter.onError(e);
						}
						
					};
				
					}
				);
		
		Observer<Integer> ob  = new Observer<Integer>() {

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println(" 구독 ");				
			}

			@Override
			public void onNext(@NonNull Integer t) {
				// TODO Auto-generated method stub
				System.out.println(" next:: "+t);				

			}

			@Override
			public void onError(@NonNull Throwable e) {
				// TODO Auto-generated method stub
				e.getStackTrace();
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("끝 ~~");
				
			}
			
			
		};
		
		source.subscribe(ob);
		
				
	}

}
