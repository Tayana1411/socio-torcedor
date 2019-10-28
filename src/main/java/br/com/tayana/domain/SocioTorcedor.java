package br.com.tayana.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tayana.enums.TimesEnum;

@Document(collection = "socio-torcedor")
public class SocioTorcedor implements Serializable{
	
	private static final long serialVersionUID = 1088671613724631995L;
	
	@Transient
	public static final String SEQUENCE_NAME = "seq_socioTorcedor";
	
	private long id;
	private String nome;
	private String email;
	private TimesEnum time;
	private List<Integer> campanhas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TimesEnum getTime() {
		return time;
	}
	public void setTime(TimesEnum time) {
		this.time = time;
	}
	public List<Integer> getCampanhas() {
		return campanhas;
	}
	public void setCampanhas(List<Integer> campanhas) {
		this.campanhas = campanhas;
	}

}
