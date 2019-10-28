package br.com.tayana;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tayana.domain.SocioTorcedor;
import br.com.tayana.enums.TimesEnum;
import br.com.tayana.repositories.SocioTorcedorRepository;
import br.com.tayana.service.SocioTorcedorService;



@SpringBootTest
class SocioTorcedorServiceTests {

	@Mock
	private SocioTorcedorRepository repository;
	
	@InjectMocks
    private SocioTorcedorService service = new SocioTorcedorService();
	
	@DisplayName("Service deve chamar repository.insert passando objeto esperado.")
	@Test
	void InsertDeveChamarRepositorio() {
		SocioTorcedor socioTorcedor = getSocioTorcedorDefault();
		service.insert(socioTorcedor);
		
		verify(repository, times(1)).save(socioTorcedor);
		verifyNoMoreInteractions(repository);
	}
	
	private SocioTorcedor getSocioTorcedorDefault() {
		SocioTorcedor socioTorcedor = new SocioTorcedor();
		
		List<Integer> campanhas = new ArrayList<>();
		campanhas.add(1);
		
		socioTorcedor.setId(1);
		socioTorcedor.setNome("Teste");
		socioTorcedor.setEmail("teste@teste.com");
		socioTorcedor.setTime(TimesEnum.ATLETICOMG);
		socioTorcedor.setCampanhas(campanhas);
		
		return socioTorcedor;
	}

}
