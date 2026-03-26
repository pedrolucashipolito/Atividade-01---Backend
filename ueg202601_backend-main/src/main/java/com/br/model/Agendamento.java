package com.br.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

//Classe responsável por representar o agendamento de um aparelho da academia. 
//Relaciona um usuário a um aparelho em uma data e horário específicos.
@Entity
@Table(name="agendamentos")
public class Agendamento {
	
	//Chave primária.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	//Data em que o aparelho está agendado.
	@Column(name="data")
	private Date data;
	
	//Hora em que o aparelho está agendado.
	@Column(name="hora")
	private String hora;
	
	//Indica se o agendamento está ativo.
	@Column(name="ativo")
	private boolean ativo;
	
	//Indica se o aparelho possui alguma observação.
	@Column(name="observacao")
	private String observacao;

	// Usuário que realizou o agendamento.
	@ManyToOne
	private Usuario usuario;

	// Aparelho que foi agendado.
	@ManyToOne
	private Aparelho aparelho;
	
	// Construtor padrão (obrigatório para o JPA)
	public Agendamento() {
	    super();
	}

	public Agendamento(Long codigo, Date data, String hora, boolean ativo, String observacao, Usuario usuario,
			Aparelho aparelho) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.hora = hora;
		this.ativo = ativo;
		this.observacao = observacao;
		this.usuario = usuario;
		this.aparelho = aparelho;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

}