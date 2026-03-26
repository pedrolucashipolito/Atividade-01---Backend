package com.br.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Classe responsável por representar um aparelho da academia.
//Contém informações sobre o usuário.
@Entity
@Table(name="usuarios")
public class Usuario {
	
	//Chave primária.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	//Nome do usuário.
	@Column(name="nome")
	private String nome;
	
	//Email do usuário.
	@Column(name="email")
	private String email;
	
	//Indica se o usuário está ou não ativo.
	@Column(name="ativo")
	private boolean ativo;
	
	//Indica o dia em que o usuário se cadastrou.
	@Column(name="dataCadastro")
	private Date dataCadastro;
	
	//Indica a idade do usuário.
	@Column(name="idade")
	private int idade;

//Construtor padrão.
	public Usuario() {
		super();
	}

public Usuario(Long codigo, String nome, String email, boolean ativo, Date dataCadastro, int idade) {
	super();
	this.codigo = codigo;
	this.nome = nome;
	this.email = email;
	this.ativo = ativo;
	this.dataCadastro = dataCadastro;
	this.idade = idade;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public boolean isAtivo() {
	return ativo;
}

public void setAtivo(boolean ativo) {
	this.ativo = ativo;
}

public Date getDataCadastro() {
	return dataCadastro;
}

public void setDataCadastro(Date dataCadastro) {
	this.dataCadastro = dataCadastro;
}

public int getIdade() {
	return idade;
}

public void setIdade(int idade) {
	this.idade = idade;
}

}