package br.com.tayana.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.tayana.domain.SocioTorcedor;
import br.com.tayana.model.CampanhaResponse;
import br.com.tayana.repositories.SocioTorcedorRepository;

@Service
public class SocioTorcedorService {

	@Autowired
	private SocioTorcedorRepository repository;

	public SocioTorcedor findByEmail(String email) {
		SocioTorcedor socioTorcedor = repository.findByEmail(email);
		return socioTorcedor;
	}

	public SocioTorcedor insert(SocioTorcedor socioTorcedorCadastrado) {
		repository.save(socioTorcedorCadastrado);
		return socioTorcedorCadastrado;
	}

}
