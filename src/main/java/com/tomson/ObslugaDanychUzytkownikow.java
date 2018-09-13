package com.tomson;
import java.util.Scanner;

public class ObslugaDanychUzytkownikow {

	private ListaUzytkownikow listaUzytkownikow;
	private final Scanner odczyt = new Scanner(System.in);
	
	public ObslugaDanychUzytkownikow(ListaUzytkownikow listaUzytkownikow){
		this.listaUzytkownikow = listaUzytkownikow;
	}

	public void usuwanieUzytkownika() { // DODAC SPRAWDZANIE PARSOWANIE
		int nrIndeksu;
		System.out.println("Podaj indeks do usuniecia");
		nrIndeksu = odczyt.nextInt(); //spytajOIndeks();
		listaUzytkownikow.remove(nrIndeksu);
	}
	
	public void dodajZawodDoWybranegoUzytkownika() {
		//wybierz jakeigos uzytkownika
		int nrIndeksu; 
		boolean stanPetli = true;
		
		while(stanPetli)
			try {
				//tu prubujesz try
				System.out.println("Podaj indeks uzytkownika do ktorego chcesz dodac zaw�d");
				nrIndeksu = Integer.parseInt(odczyt.nextLine());
				
				if ( nrIndeksu >= 0 && listaUzytkownikow.size() > nrIndeksu ) {
				
					Uzytkownik uzytkownik = listaUzytkownikow.get(nrIndeksu);
					//odpla dodawnia zawodow do teog uyzwkonika
					dodajZawodyWPetli(uzytkownik);
					stanPetli = false;
				
				}else {
					System.out.println("Poda�e� zjebany numer albo niema uzytkownika o takim indeksie, sprub�j jeszcze raz");	
					stanPetli = true;
				}
				
			} catch(NumberFormatException e) {
				//tu lapiesz wyjatek i wypisujesz  sprubuj jescze raz
				System.out.println(e.getMessage());
				System.out.println("Poda�e� litery zamiast numeru, sprub�j jeszcze raz");
				stanPetli = true;
			}	
	
		//czy podal uzytkownik liczbe a nie huja ZROBIONE
		//czy liczba  nie jest  ujemna
		//czy liczba  nie jest wieksza  niz rozmiar listy   metoda  .size() zwraca rozmair listy wywo;lana na lsicie
		
		
	}
	
	public void dodajZawodyWPetli(Uzytkownik uzytkownik) {
	
		boolean stanPetli = true;
		String wartosc;
		//tu zacznij petle
		while(stanPetli) {
			
			System.out.println("Czy chcesz dodac zaw�d do uzytkownika? y/n");  
			wartosc = odczyt.nextLine();
			if (wartosc == null || wartosc.isEmpty() || (!wartosc.equals("n") && !wartosc.equals("y"))) {
				System.out.println("Nie wybra�e� poprawnej opcji");
			} else if (wartosc.equals("y")) {
				Zawod zawod = this.stworzZawod();
				uzytkownik.getListaZawodow().add(zawod);
			} else if (wartosc.equals("n")) {
				stanPetli = false; 
			} 
			//tu ja  zakoncz
		}
	}
	
	public void edycjaUzytkownika() {  // 
		int nrIndeksu;
		System.out.println("Podaj indeks do zamienienia");
		nrIndeksu = odczyt.nextInt();
		Uzytkownik uzytkownik = listaUzytkownikow.get(nrIndeksu);
		edytujUzytkownika(uzytkownik);
		odczyt.nextLine();
	}
	
	public void edytujUzytkownika(Uzytkownik uzytkownik) {
		stworzUzytkownika(uzytkownik);
	}
	
	public void stworzUzytkownika() {
		listaUzytkownikow.addUzytkownik(stworzUzytkownika(new Uzytkownik()));
	}
	
	public Uzytkownik stworzUzytkownika(Uzytkownik nowyUzytkownik) {
		boolean stanPetli = true;
		
		if(nowyUzytkownik == null) {
			nowyUzytkownik = new Uzytkownik();
		}
		
		System.out.println("Podaj imie");
		nowyUzytkownik.setImie(odczyt.nextLine());
		System.out.println("Podaj nazwisko");
		nowyUzytkownik.setNazwisko(odczyt.nextLine());
		System.out.println("Podaj email");
		nowyUzytkownik.setEmail(odczyt.nextLine());
		
		while(stanPetli) {
			try {
				//tu prubujesz try
				System.out.println("Podaj telefon");
				nowyUzytkownik.setTelefon(Integer.parseInt(odczyt.nextLine()));
				stanPetli = false;
			} catch(NumberFormatException e) {
				//tu lapiesz wyjatek i wypisujesz  sprubuj jescze raz
				System.out.println(e.getMessage());
				System.out.println("Poda�e� nie w�asciwy numer");
				stanPetli = true;
			}	
		}
		nowyUzytkownik.setAdres(stworzAdres());
		dodajZawodyWPetli(nowyUzytkownik);
		return nowyUzytkownik;	
	}
	
	public Adres stworzAdres() {
		//stworz adres
		final Adres nowyAdres = new Adres();
			
		//zczytaj z konsoli dane adresowe
		System.out.println("Podaj Ulice");
		nowyAdres.setUlica(odczyt.nextLine());
		System.out.println("Podaj Nr. Ulicy");
		nowyAdres.setNrUlicy(odczyt.nextLine());
		System.out.println("Podaj PostCode");
		nowyAdres.setPostCode(odczyt.nextLine());
		System.out.println("Podaj Miasto");
		nowyAdres.setMiasto(odczyt.nextLine());	
		
		return nowyAdres;
	}
	
	public void edycjaAdresu() {
		int nrIndeksu;
		
		System.out.println("Podaj indeks uzytkownika ktorego adres chcesz zmienic");
		
		nrIndeksu = odczyt.nextInt();

		Uzytkownik doZamiany = listaUzytkownikow.get(nrIndeksu);
		if(doZamiany == null) {
			System.out.println("Pod tym indeksem nie ma zadnego uzytkownika");
			return;
		}
		odczyt.nextLine();	
		doZamiany.setAdres(stworzAdres());
		
		//listaUzytkownikow.set(nrIndeksu,doZamiany);
	}
	
	public Zawod stworzZawod() {

		System.out.println("Podaj Stanowisko");
		String stanowisko = odczyt.nextLine();
		System.out.println("Podaj okres zatrudnienia");
		String okres = odczyt.nextLine();
		System.out.println("Podaj doswiadczenie");
		String doswiadczenie = odczyt.nextLine();
		
		return stworzZawod(stanowisko, okres, doswiadczenie);
	}
	
	public Zawod stworzZawod(String stanowisko, String okres, String doswiadczenie) {
		final Zawod newZawod = new Zawod();
		
		newZawod.setStanowisko(stanowisko);
		newZawod.setOkres(okres);
		newZawod.setDoswiadczenie(doswiadczenie);
		
		return newZawod;
	}
}