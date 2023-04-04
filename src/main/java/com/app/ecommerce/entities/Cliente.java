package com.app.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.ecommerce.enums.AtivoBloqStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLI_ID")
	private Integer cliId;
	
	@Getter
	@Setter
	@Column(length = 45, name = "CLI_NOME")
	private String cliNome;
	
	@Getter
	@Setter
	@Column(length = 15, name = "CLI_CELULAR")
	private String cliCelular;
	
	@Getter
	@Setter
	@Column(name = "CLI_CPF", unique = true)
	private String cliCpf;
	
	@Getter
	@Setter
	@Column(name = "CLI_EMAIL", unique = true)
	private String cliEmail;
	
	@Column(name = "CLI_STATUS")
	private Integer cliStatus;
	
	@Getter
	@Setter
	@JsonIgnore
	@Column(name = "CLI_SENHA")
	private String cliSenha;

	public Cliente() {
	}

	public Cliente(Integer cliId, String cliNome, String cliCelular, String cliCpf, String cliEmail, AtivoBloqStatus cliStatus,
			String cliSenha) {
		super();
		this.cliId = cliId;
		this.cliNome = cliNome;
		this.cliCelular = cliCelular;
		this.cliCpf = cliCpf;
		this.cliEmail = cliEmail;
		this.cliStatus = (cliStatus==null) ? null : cliStatus.getCod();
		this.cliSenha = cliSenha;
	}
	
	public AtivoBloqStatus getCliStatus() {
		return AtivoBloqStatus.toEnum(cliStatus);
	}

	public void setCliStatus(AtivoBloqStatus cliStatus) {
		this.cliStatus = cliStatus.getCod();
	}
}