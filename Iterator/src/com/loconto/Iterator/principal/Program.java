package com.loconto.Iterator.principal;

import java.util.Arrays;

import com.loconto.Iterator.reseau.IPInterval;

public class Program {

	public static void main(String[] args) {
		IPInterval ipi1 = new IPInterval(100, 100, 100, 50, 192, 100, 110, 25);	
		
		System.out.println("l'adresse ip 100.100.100.20 est dans l'intervalle " + ipi1.isInInterval(100,100,100,20));
		System.out.println("l'adresse ip 100.100.100.60 est dans l'intervalle " + ipi1.isInInterval(100,100,100,60));
		System.out.println("l'adresse ip 100.100.110.20 est dans l'intervalle " + ipi1.isInInterval(100,100,110,20));
		System.out.println("l'adresse ip 100.100.80.60 est dans l'intervalle " + ipi1.isInInterval(100,100,80,60));
		
		for(Integer[] ip : ipi1){
			System.out.println(Arrays.toString(ip));
		}
		
	}

}
