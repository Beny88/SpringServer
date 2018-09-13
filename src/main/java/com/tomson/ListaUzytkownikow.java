package com.tomson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaUzytkownikow {

	private List<Uzytkownik> listaUzytkownikow = new ArrayList<Uzytkownik>();
	
	public void addUzytkownik(Uzytkownik nowyUzytkownik) {
		listaUzytkownikow.add(nowyUzytkownik);
	}
	
	public Uzytkownik get(int i) {
		if(listaUzytkownikow.size() > i) {
			return listaUzytkownikow.get(i);
		} else {
			return null;
		}
	}
	
	public void remove(int i) {
		listaUzytkownikow.remove(i);
	}
				 
	public void wysweitlDane() {
		System.out.println("Rozmiar listy to: "+listaUzytkownikow.size());
		
		for (int i = 0; i < listaUzytkownikow.size(); i++) {
			//System.out.println(String.format("Uzytkownik nr: %s %s", i, listaUzytkownikow.get(i).podajSwojeDane()));
		}
		
		List<Uzytkownik> listaMarcinow = listaUzytkownikow.stream().filter(uzytkownik -> uzytkownik.getImie().equals("Marcin")).collect(Collectors.toList());

		
		//listaUzytkownikow.stream().forEach(uzytkownik -> String.format("Uzytkownik %s", uzytkownik.podajSwojeDane()));
		
		listaUzytkownikow.stream().forEach(uzytkownik -> {
			//cos tu robisz
		});
				
		listaUzytkownikow.addAll(listaMarcinow);
	}

	public int size() { 
		return listaUzytkownikow.size();
	}

	
	
	/*public void set(int nrIndeksu, Uzytkownik zastepczy) {
		listaUzytkownikow.set(nrIndeksu, zastepczy);
		
	}	*/	
}
