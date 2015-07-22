package com.loncoto.TestThread3.principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.loncoto.TestThread3.utils.Worker1;

public class Program {
	
	public static void main(String[] arg){
		
		int nbCoeurs = Runtime.getRuntime().availableProcessors();
		System.out.println("cette machine a " + nbCoeurs +" coeurs processeurs");
		
		System.out.println("debut ....");
		try {
			//Thread.sleep permet de mettre en pause un thread
			//ici le thread principal celui du main
			//pas les threads du srv
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("demarrage du programme ....");
		
		ExecutorService srv = Executors.newFixedThreadPool(4);
		
		srv.execute(new Worker1("worker a"));
		srv.execute(new Worker1("worker b"));
		srv.execute(new Worker1("worker c"));
		srv.execute(new Worker1("worker d"));
		srv.execute(new Worker1("worker e"));
		srv.execute(new Worker1("worker f"));
		
		//on lui dit tu fini ttes les taches planifiées
		//mais n'accepte plus de nouvelles taches
		System.out.println("------------------- attemping shutdown.....");
		srv.shutdown();
		
		
		try {
			while(true){
				//j attend 1s maxi que le thread pool se termine
				System.out.println(" ------------------- waiting for shutdwon complete -------------------");
				srv.awaitTermination(1, TimeUnit.SECONDS);
				if(srv.isTerminated()){ break; }
				System.out.println(" ------------------- le processus n'est pas fini --------------------");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
