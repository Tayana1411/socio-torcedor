package br.com.tayana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tayana.domain.SocioTorcedor;
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
