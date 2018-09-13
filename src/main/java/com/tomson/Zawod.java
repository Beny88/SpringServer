package com.tomson;

public class Zawod {
	
	private String stanowisko;
	private String okres;
	private String doswiadczenie;
	
	
	public Zawod() {	
	}
	
	public Zawod(String stanowisko, String okres, String doswiadczenie) {
		this.stanowisko = stanowisko;
		this.okres = okres;
		this.doswiadczenie = doswiadczenie;
	}
	
	public String podajDaneZawodow() {
		return String.format("%s %s %s ", 
				stanowisko, 
				okres, 
				doswiadczenie 
				);
	}
	

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public String getOkres() {
		return okres;
	}

	public void setOkres(String okres) {
		this.okres = okres;
	}

	public String getDoswiadczenie() {
		return doswiadczenie;
	}

	public void setDoswiadczenie(String doswiadczenie) {
		this.doswiadczenie = doswiadczenie;
	}

}
