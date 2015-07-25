package com.loncoto.TestThread2.principal;

import com.loncoto.TestThread2.utils.CompteurPartage;
import com.loncoto.TestThread2.utils.Worker1;

public class Program {
	
	public static void main(String[] args){
		
		//on cree une seule instance de compteurPartage
		CompteurPartage compteur = new CompteurPartage();
		
		//les 3 threads
		Thread t1 = new Thread(new Worker1(compteur, "w1"));
		Thread t2 = new Thread(new Worker1(compteur, "w2"));
		Thread t3 = new Thread(new Worker1(compteur, "w3"));
		
		System.out.println("demarrage");
		System.out.println(compteur);
		t1.start();
		t2.start();
		t3.start();		
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(compteur);
		
		
		
	}

}
