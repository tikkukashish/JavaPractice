package com.edtech.my_edtech_product;
import java.util.TreeSet;

public class TreeSetPrograms {
	public static void main(String[] args) {

        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(10);
        ts.add(5);
        ts.add(20);
        ts.add(10); 

        System.out.println(ts);
        
        int check = 10;

        System.out.println("Contains " + check + " "
                           + ts.contains(check));

        System.out.println("First Value " + ts.first());

        System.out.println("Last Value " + ts.last());

        int val = 15;

        
        System.out.println("Higher " + ts.higher(val));
        System.out.println("Lower " + ts.lower(val));
        
        ts.remove(5);

        System.out.println("After removing element " + ts);
        ts.pollFirst();

        System.out.println("After removing first " + ts);

        ts.pollLast();

        System.out.println("After removing last " + ts);
        
        for (int value : ts)
            System.out.print(value + ", ");

        System.out.println();
    }
}
