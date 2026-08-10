package com.java_questions.practice;
import java.util.Scanner;

public class CalculateCompoundInterest {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter principal: ");
	        double p = sc.nextDouble();
	        System.out.print("Enter rate: ");
	        double r = sc.nextDouble();
	        System.out.print("Enter time in years: ");
	        double t = sc.nextDouble();

	        
	        double CI = p * (Math.pow((1 + r / 100), t));
        
	        System.out.println("Compound Interest is "+ CI);
	 }
}
