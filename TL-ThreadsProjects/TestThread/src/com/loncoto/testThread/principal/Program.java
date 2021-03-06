package com.loncoto.testThread.principal;

import java.util.Scanner;

import com.loncoto.testThread.utils.Worker1;

public class Program {

	public static void main(String[] args) {
		
		Worker1 w1 = new Worker1("worker-a");
		Worker1 w2 = new Worker1("worker-b");
		Worker1 w3 = new Worker1("worker-c");

		//le thread est cr�e mais non d�marr�
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
		Thread t3 = new Thread(w3);
		
		
		System.out.println("D�marrage du thread 1");
		t1.start();
		System.out.println("D�marrage du thread 2");
		t2.start();
		System.out.println("D�marrage  de worker c dans main");
		t3.start();
		
		

		
		try {
			while (true) {
				System.out.println("attente de thread 1, forcer arret ?");
				Scanner reader = new Scanner(System.in);
				
				if(reader.hasNext()){ 
					w1.setMustStop(true);
					w2.setMustStop(true);
					w3.setMustStop(true);
				}
				t1.join(1000);
				if (!t1.isAlive())
					break;
			}
			System.out.println("attente de thread 2");
			t2.join();
			System.out.println("attente de thread 3");
			t3.join();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---------------- FINI ---------------------------");
		
	}

}
