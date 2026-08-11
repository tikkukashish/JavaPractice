package com.edtech.my_edtech_product;

import java.util.Vector;
import java.util.Iterator;

public class VectorPrograms {

    public static void main(String[] args) {

        Vector<String> v = new Vector<>();
        v.add("Java");
        v.add("Python");
        v.add("C++");
        v.add("SQL");

        System.out.println("Original Vector: " + v);
        v.set(1, "C#");

        System.out.println("After updating: " + v);
        v.remove("C++");

        System.out.println("After removing C++: " + v);
        v.remove(0);

        System.out.println("After removing index 0: " + v);
        System.out.println("Iterating Vector:");

        for (String element : v) {
            System.out.println(element);
        }
        System.out.println("Using Iterator:");

        Iterator<String> itr = v.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}