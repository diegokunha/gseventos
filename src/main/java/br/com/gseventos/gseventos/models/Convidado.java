package br.com.gseventos.gseventos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Convidado {

	@Id
	@CPF
	@Column(name="cpf")
	private String cpf;
	
	@NotEmpty
	@Column(name="nome")
	private String nome;
	
	@Column(name="contato")
	private String contato;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="idEvento", foreignKey=@ForeignKey(name="Convidado_IdEvento"))
	private Evento evento;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	

}
