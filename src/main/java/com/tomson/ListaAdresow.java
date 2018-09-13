package com.tomson;

import java.util.ArrayList;
import java.util.List;

public class ListaAdresow {
	
	private List<Adres> listaAdresow = new ArrayList<>();

	public void addAdres(Adres nowyAdres) {
		listaAdresow.add(nowyAdres);
	}
				 
	public void wysweitlDane() {
		for (int i = 0; i < listaAdresow.size(); i++) {
			System.out.println(listaAdresow.get(i));
		}
		System.out.println("Rozmiar listy to: "+listaAdresow.size());
	}
}

