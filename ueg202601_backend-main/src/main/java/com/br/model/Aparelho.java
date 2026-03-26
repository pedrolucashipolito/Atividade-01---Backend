package com.br.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Classe responsável por representar um aparelho da academia.
//Contém informações sobre o equipamento.
@Entity
@Table(name="aparelhos")
public class Aparelho {
	
	//Chave primária.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	//Nome do aparelho.
	@Column(name="nome")
	private String nome;
	
	//Tipo do aparelho, ex: musculação, cardio.
	@Column(name="tipo")
	private String tipo;
	
	//Indica se o aparelho está disponível para uso.
	@Column(name="disponivel")
	private boolean disponivel;
	
	//Indica se o aparelho está ou não em manutenção.
	@Column(name="dataManutencao")
	private Date dataManutencao;
	
	//Carga máxima suportada pelo aparelho.
	@Column(name="carga")
	private double carga;
	
	//Construtor padrão.
	public Aparelho() {
		super();
	}

	public Aparelho(Long codigo, String nome, String tipo, boolean disponivel, Date dataManutencao, double carga) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.disponivel = disponivel;
		this.dataManutencao = dataManutencao;
		this.carga = carga;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}
}