package com.edtech.my_edtech_product;
import java.util.Map;
import java.util.TreeMap;
public class TreeMapPrograms {
	 static void Constructor(){

	        TreeMap<Integer, String> tm = new TreeMap<>();

	       
	        tm.put(10, "Dhruvi");
	        tm.put(15, "Fairy");
	        tm.put(20, "Ayushi");

	        System.out.println("TreeMap: " + tm);
	    }

	    public static void main(String[] args){

	        System.out.println(
	            "TreeMap using TreeMap() constructor");
	        Constructor();
	       

	        TreeMap<Integer, String> tm1 = new TreeMap<>();

	        tm1.put(3, "Language");
	        tm1.put(2, "Programming");
	        tm1.put(1, "Java");

	        System.out.println("TreeMap with generics: " + tm1);
	        tm1.put(2, "For");

	        System.out.println(tm1);
	        tm1.remove(2);

	        System.out.println(tm1);
	        
	        for (Map.Entry<Integer, String> e : tm1.entrySet()) {
	            int k = e.getKey();
	            String v = e.getValue();
	            
	            System.out.println(k + " : " + v);
	        }
	    
	    }
}
