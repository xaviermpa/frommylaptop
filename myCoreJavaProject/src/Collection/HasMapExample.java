package Collection;

import java.util.HashMap;

public class HasMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "clean world green world happy world"; 
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();	 
		String[] words = str1.split(" ");
		 for (String word : words) {
		            Integer integer = map1.get(word);
		            if (integer == null)
		                map1.put(word, 1);
		 
		            else {
		                map1.put(word, integer + 1);
		            }
		        }
		        System.out.println(map1);
		
		       // System.out.println(map1.getOrDefault("world", 1));
		        
	}

}
