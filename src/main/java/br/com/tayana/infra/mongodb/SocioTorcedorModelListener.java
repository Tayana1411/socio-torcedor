package br.com.tayana.infra.mongodb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import br.com.tayana.domain.SocioTorcedor;


	@Component
	public class SocioTorcedorModelListener extends AbstractMongoEventListener<SocioTorcedor> {

	    private SequenceGeneratorService sequenceGenerator;

	    @Autowired
	    public SocioTorcedorModelListener(SequenceGeneratorService sequenceGenerator) {
	        this.sequenceGenerator = sequenceGenerator;
	    }

	    @Override
	    public void onBeforeConvert(BeforeConvertEvent<SocioTorcedor> event) {
	        if (event.getSource().getId() < 1) 
	            event.getSource().setId(sequenceGenerator.generateSequence(SocioTorcedor.SEQUENCE_NAME));
	        
	    }


	}