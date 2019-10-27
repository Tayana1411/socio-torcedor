package br.com.tayana.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tayana.domain.SocioTorcedor;

public interface SocioTorcedorRepository extends MongoRepository<SocioTorcedor, Integer>{
	
	@Query("{email: ?0}")
	public SocioTorcedor findByEmail(String email);

}
