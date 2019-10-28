package br.com.tayana.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.tayana.command.SocioTorcedorCommandFactory;
import br.com.tayana.command.model.RegisterSocioTorcedorCmd;
import br.com.tayana.model.SocioTorcedorRequest;

@RestController
@RequestMapping(value="/socioTorcedor")
public class SocioTorcedorResource {
	
	@Autowired
	SocioTorcedorCommandFactory commandFactory;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody SocioTorcedorRequest request) {
		RegisterSocioTorcedorCmd cmd = commandFactory.createInstance(RegisterSocioTorcedorCmd.class);
		cmd.setRequest(request);
		cmd.execute();
		return ResponseEntity.ok().body(cmd.getResponse());
	}
	
}
