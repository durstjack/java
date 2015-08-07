package com.loncoto.webbapps.JunitCalculatrice.beans;

public class Calculatrice {
	
	public static int division(int a, int b){
		return a / b ;		
	}
	
	public static double accumuler(double ...values){
		double somme = 0.0;
		for( double d : values){
			somme += d;
		}
		return somme;
	}
	
	public static double multiplier(double ...values){
		double total = 1.0;
		for( double d : values){
			total *= d;
		}
		return total;
	}

}
