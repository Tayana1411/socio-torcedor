package br.com.tayana.model;

import java.util.List;

import br.com.tayana.enums.TimesEnum;

public class SocioTorcedorResponse {
	
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
