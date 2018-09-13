package com.tomson;

public class Adres {
	
	private String ulica;
	private String nrUlicy;
	private String postCode;
	private String miasto;
	
	public Adres() {
		
	}
	
	/*public Adres(String ulica, String nrUlicy, String postCode, String miasto) {
		this.ulica = ulica;
		this.nrUlicy = nrUlicy;
		this.postCode = postCode;
		this.miasto = miasto;
	}*/

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNrUlicy() {
		return nrUlicy;
	}

	public void setNrUlicy(String nrUlicy) {
		this.nrUlicy = nrUlicy;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	
}