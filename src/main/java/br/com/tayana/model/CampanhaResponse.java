package br.com.tayana.model;

import java.time.LocalDate;

public class CampanhaResponse {
	
	private Integer id;
	private Integer idTime;
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdTime() {
		return idTime;
	}
	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

}
