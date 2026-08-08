package com.java_questions.practice;
import java.util.Scanner;

public class CalculateSimpleInterest {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter principal: ");
	        double p = sc.nextDouble();
	        System.out.print("Enter rate: ");
	        double r = sc.nextDouble();
	        System.out.print("Enter time in years: ");
	        double t = sc.nextDouble();

	        double si = (p * r * t) / 100;
	        System.out.println("Simple Interest = " + si);
	    }
}
