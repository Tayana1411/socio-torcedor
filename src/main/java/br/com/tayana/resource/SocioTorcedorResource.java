package br.com.tayana.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tayana.model.SocioTorcedorRequest;

@RestController
@RequestMapping(value="/socioTorcedor")
public class SocioTorcedorResource {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody SocioTorcedorRequest request) {
		String uri = "http://localhost:8080/swagger-ui.html#/campanha-resource/findCampanhasUsingGET/";
	
	}
	
}
