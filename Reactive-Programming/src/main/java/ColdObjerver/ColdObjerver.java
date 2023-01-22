package ColdObjerver;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;

public class ColdObjerver {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList();
		list.add("just");
		list.add("look");
		list.add("Football");
		
		Observable cold = Observable.fromIterable(list);
		cold.subscribe(s -> System.out.println(s));
		System.out.println("++++++++++++++++++++");
		
		list = getLisst(list);
		
		cold.subscribe(s -> System.out.println(s));
		
	}
	
	public static ArrayList getLisst(ArrayList list) {
		
		
		list.add("kim");
		list.add("choi");
		list.add("park");
		
		return list;
		
		
	}
	

}
