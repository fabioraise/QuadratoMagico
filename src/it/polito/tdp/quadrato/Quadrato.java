package it.polito.tdp.quadrato;

import java.util.ArrayList;
import java.util.List;

public class Quadrato {
	
	private int size ;
	private List<Integer> mappa ;
	private int size2, sommaMagica ;
	
	public Quadrato(int size) {
		this.setSize(size) ;
		mappa = new ArrayList<Integer>() ; // mappa dei valori del quadrato
		size2 = size * size ;
		sommaMagica = ( (size2*(size2+1))/2 ) / size ; // Valore della somma delle righe, colonne, diagonali
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void add(Integer n) {
		this.mappa.add(n) ;
	}
	
	public void remove(int i) {
		this.mappa.remove(new Integer(i)) ;
	}

	public boolean contains(int i) {
		return this.mappa.contains(i);
	}

	@Override
	public Quadrato clone() {
		Quadrato q = new Quadrato(this.size) ;
		q.mappa = new ArrayList<>(this.mappa) ;
		return q ;
	}

	private int get(int riga, int col) {
		return mappa.get(riga*size+col) ;
	}
	
	public boolean isMagic() {
		// controlla righe
		for(int riga=0; riga<size; riga++) {
			int somma = 0 ;
			for(int col=0; col<size; col++)
				somma += get(riga, col) ;
			if (somma!=sommaMagica)
				return false ;
		}
		
		// controlla colonne
		for(int col=0; col<size; col++) {
			int somma = 0 ;
			for(int riga=0; riga<size; riga++)
				somma += get(riga, col) ;
			if (somma!=sommaMagica)
				return false ;
		}
		
		// controlla diagonale 1 \
		int somma = 0 ;
		for(int riga=0; riga<size; riga++)
			somma+=get(riga, riga) ;
		if (somma!=sommaMagica)
			return false ;

		// controlla diagonale 2 /
		somma = 0 ;
		for(int riga=0; riga<size; riga++)
			somma+=get(riga, size-riga-1) ;
		if (somma!=sommaMagica)
			return false ;
		
		// se tutte le somme quadrano
		return true;
	}
	
	@Override
	public String toString() {
		return this.mappa.toString() ;
	}
}
