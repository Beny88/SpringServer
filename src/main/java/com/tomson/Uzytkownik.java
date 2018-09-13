package com.tomson;

import java.util.ArrayList;
import java.util.List;

public class Uzytkownik {
	
	private Long id;
	private String imie;
	private String nazwisko;
	private String email;
	private int telefon;
	private Adres adres = null;
	private List<Zawod> listaZawodow = new ArrayList();
	//tu stworz zmeinna typu List
	
	public Uzytkownik() {
		
	}

/*	public Uzytkownik(String imie, String nazwisko, String email, int telefon, Adres adres) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.telefon = telefon;
		this.adres = adres;
	}*/

	
	
	public String getImie() {
		return imie;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImie(final String imie) {
		this.imie = imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getTelefon() {
		return telefon;
	}
	
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public void setAdres(Adres nowyAdres) {
		this.adres = nowyAdres;
	}

	public Adres getAdres() {
		return adres;
	}

	public List<Zawod> getListaZawodow() {
		return listaZawodow;
	}

	public void setListaZawodow(List<Zawod> listaZawodow) {
		this.listaZawodow = listaZawodow;
	}

	public static String powiedzCos() {
		return "asdas";
	}
}


