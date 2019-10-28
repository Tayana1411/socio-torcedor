package br.com.tayana.model;

import br.com.tayana.enums.TimesEnum;

public class SocioTorcedorRequest {

	private String nome;
	private String email;
	private TimesEnum time;

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
