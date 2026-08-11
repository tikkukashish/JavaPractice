package com.edtech.my_edtech_product;
import java.util.ArrayList;
import java.util.Collections;
public class CollectionPrograms {
	public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();

        al.add("Apple");
        al.add("Banana");
        al.add("Orange");
        al.add("Guava");
        Collections.sort(al); 

        System.out.println(al);
        al.remove("Banana");

        al.remove(0);

        System.out.println("After Removing: " + al);
        
        al.set(0, "Mango");

        // Print updated list
        System.out.println("After Updating: " + al);
        
        
    }
}
