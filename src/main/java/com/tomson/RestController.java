package com.tomson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	List<Uzytkownik> uzytkownikList = new ArrayList();
	
	@GetMapping(value = "/hello")
	public String getHello() {
		return "<b>Hello World</b>";
	}

	@GetMapping(value = "/uzytkownik/{idUzytkownika}")
	public Uzytkownik getUzytkownik(@PathVariable(value = "idUzytkownika") int idUzytkownika) {
		
		return uzytkownikList.get(idUzytkownika);
	}
	
	@PostMapping(value = "/uzytkownik")
	public Uzytkownik stworzUzytkownika(@RequestBody Uzytkownik uzytkownik) {
		
		uzytkownik.setId(123123L);
		uzytkownikList.add(uzytkownik);
		
		return uzytkownik;
	}
	
	@GetMapping(value = "/lista/uzytkownik")
	public List<Uzytkownik> getListaUzytkownik() {
		return uzytkownikList;
	}
}
