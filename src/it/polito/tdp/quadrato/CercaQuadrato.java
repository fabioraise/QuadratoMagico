package it.polito.tdp.quadrato;

import java.util.ArrayList;
import java.util.List;

public class CercaQuadrato {
	

	public CercaQuadrato() {
	}

	List<Quadrato> soluzioni;
	
	public void genera(int size) {
		Quadrato parziale = new Quadrato(size) ;
		this.soluzioni= new ArrayList<Quadrato>() ;
		this.cerca(parziale, 0);
	}
	
	// 1° metodo
	private void cerca(Quadrato parziale, int L) {
		// le L caselle da 0 a L-1 sono piene
		// devo trovare un valore per la casella in posizione L
		
		
		/*
		 * Quando il quadrato ha raggiunto il valore L (= size^2) verifico
		 * se esso sia magico, ovvero se la somma su righe e colonne sia pari
		 * a sommaMagica, valore interno alla classe quadrato, attraverso la funzione isMagic()
		 */
		if (L == parziale.getSize() * parziale.getSize()) {
			// il quadrato è tutto pieno
			// devo verificare se è 'magico'
			if (parziale.isMagic()) {
				System.out.println(parziale) ;
				soluzioni.add(parziale.clone());
				// devo clonare il quadrato perchè se poi verrà modificato dall'algoritmo diventerà
				// inutilizzabile per successive elaborazioni
			}
			return;
		}

		for (int i = 1; i <= parziale.getSize() * parziale.getSize(); i++) {
			
			// provo a mettere il valore 'i' nella casella 'L'
			if (!parziale.contains(i)) {
				parziale.add(i); // aggiungo il valore i alla lista di valori del quadrato parziale
				
				// ricorsivamente aggiungo gli altri valori al parziale aumentando il
				// numero della casella
				cerca(parziale, L + 1);
				
				// che il quadrato sia stato valutato magico o meno, rimuovo il valore i "appena"
				// inserito per far spazio agli altri valori (che riesco a mettere attraverso il ciclo
				// for) e continuare a vedere quali altri quadrati magici riesco a trovare
				parziale.remove(i);
			}
		}
	}

}
