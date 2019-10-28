package br.com.tayana.command.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.tayana.command.SocioTorcedorLogicCommand;
import br.com.tayana.domain.Campanha;
import br.com.tayana.domain.SocioTorcedor;
import br.com.tayana.infra.mongodb.SequenceGeneratorService;
import br.com.tayana.model.CampanhaResponse;
import br.com.tayana.model.SocioTorcedorRequest;
import br.com.tayana.model.SocioTorcedorResponse;
import br.com.tayana.service.SocioTorcedorService;

@Component
public class RegisterSocioTorcedorCmd implements SocioTorcedorLogicCommand {

	private SocioTorcedorRequest request;
	private SocioTorcedorResponse response;
	private SocioTorcedorService service;
	private SequenceGeneratorService sequenceGenerator;
	
	public RegisterSocioTorcedorCmd(SocioTorcedorService service, SequenceGeneratorService sequenceGenerator) {
		this.service = service;
		this.sequenceGenerator = sequenceGenerator;
	}

	@Override
	public void execute() {

		 SocioTorcedor socioTorcedorCadastrado;
		 
		 socioTorcedorCadastrado = service.findByEmail(getRequest().getEmail());
		
		 if(socioTorcedorCadastrado == null) {
			 socioTorcedorCadastrado = new SocioTorcedor();
			 socioTorcedorCadastrado.setId(sequenceGenerator.generateSequence(SocioTorcedor.SEQUENCE_NAME));
			 socioTorcedorCadastrado.setNome(getRequest().getNome());
			 socioTorcedorCadastrado.setEmail(getRequest().getEmail());
			 socioTorcedorCadastrado.setTime(getRequest().getTime());
		 }

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<CampanhaResponse>> responseEntity = restTemplate.exchange(
				"http://localhost:8080/campanha/time/" + socioTorcedorCadastrado.getTime().getId(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<CampanhaResponse>>() {
				});
		List<CampanhaResponse> campanhas = responseEntity.getBody();

		if (socioTorcedorCadastrado.getCampanhas() == null) {
			socioTorcedorCadastrado.setCampanhas(new ArrayList<Integer>());
		}
		
		for (CampanhaResponse campanha : campanhas) {
			if (!socioTorcedorCadastrado.getCampanhas().contains(campanha.getId())) {
				socioTorcedorCadastrado.getCampanhas().add(campanha.getIdTime());
			}
		}

		socioTorcedorCadastrado = service.insert(socioTorcedorCadastrado);
		
		response = new SocioTorcedorResponse();
		response.setId(socioTorcedorCadastrado.getId());
		response.setEmail(socioTorcedorCadastrado.getEmail());
		response.setNome(socioTorcedorCadastrado.getNome());
		response.setTime(socioTorcedorCadastrado.getTime());
		response.setCampanhas(socioTorcedorCadastrado.getCampanhas());
	}

	public SocioTorcedorRequest getRequest() {
		return request;
	}

	public void setRequest(SocioTorcedorRequest request) {
		this.request = request;
	}

	public SocioTorcedorResponse getResponse() {
		return response;
	}

	public void setResponse(SocioTorcedorResponse response) {
		this.response = response;
	}

}
