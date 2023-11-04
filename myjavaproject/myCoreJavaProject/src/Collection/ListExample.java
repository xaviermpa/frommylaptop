package Collection;

import java.util.ArrayList;
import java.util.Collections;


public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] name = {"xavier","emily","Gavina","Nethu"};
		
		ArrayList<String> list1 = new ArrayList<String>();
		
		//add to list
		list1.add(name[0]);
		list1.add(name[1]);
		list1.add(name[2]);
		list1.add(name[3]);
		
		System.out.println(list1);
		System.out.println(list1.get(0));

		
		list1.remove(0);

		System.out.println(list1);
		System.out.println(list1.get(0));
		
		//to print last value
		System.out.println(list1.get(list1.size()-1));
		
	
		//change list valu use Set
		list1.add("x");
		System.out.println(list1);

		list1.set(list1.size()-1, "Belatria");
		System.out.println(list1);
		
		for(int i=0; i<list1.size();i++)
		{
		System.out.println(list1.get(i));
		}
		
		for(String name1:list1) 
		{		
			System.out.println(name1);
		}
		

		Collections.sort(list1);
		System.out.println(list1);

		// Sorting of the data in descending order
				Collections.sort(list1,Collections.reverseOrder());
				System.out.println(list1);
				
		
		}
	
}
