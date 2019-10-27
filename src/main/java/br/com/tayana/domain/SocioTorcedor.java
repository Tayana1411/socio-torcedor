package br.com.tayana.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tayana.enums.TimesEnum;

@Document(collection = "socio-torcedor")
public class SocioTorcedor implements Serializable{
	
	private static final long serialVersionUID = 1088671613724631995L;
	
	private Integer id;
	private String nome;
	private String email;
	private TimesEnum time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

}
