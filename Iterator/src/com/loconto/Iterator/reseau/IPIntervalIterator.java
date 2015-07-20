package com.loconto.Iterator.reseau;

import java.util.Iterator;

public class IPIntervalIterator implements Iterator<Integer[]> {
	
	//interval sur lequel je vais itérer
	private IPInterval interval;
	private int[] current;

	//constructeur
	public IPIntervalIterator(IPInterval interval) {
		this.interval = interval;
		//je me positionne sur l'ip de début
		current = interval.getIpStart();
	}
	
	@Override
	public boolean hasNext() {
		return(interval.isInInterval(current[0], current[1], current[2], current[3]));
	}

	@Override
	public Integer[] next() {
		// je recupere l'ip sous forme d'un chiffre
		long cur = ((long)current[0] << 24) + (current[1] << 16) + (current[2] <<  8) + current[3];	
		//j'increment pour le net
		cur++;
		//je prepare le tableau avec l'ip courante pour après le renvoyer renvoyer
		Integer[] curip = { current[0], current[1], current[2], current[3] };
		
		current[0] = (int)(cur >> 24) & 255 ;
		current[1] = (int)(cur >> 16) & 255 ;
		current[2] = (int)(cur >> 8) & 255 ;
		current[3] = (int)(cur & 255) & 255 ;
				
		return curip;
	}

}
