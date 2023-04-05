package com.app.ecommerce.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String cliNome;
	
	@Getter
	@Setter
	private String cliCelular;
	
	@Getter
	@Setter
	private String cliCpfCnpj;
	
	@Getter
	@Setter
	private String cliEmail;
	
	@Getter
	@Setter
	private Integer cliStatus;
	
	@Getter
	@Setter
	private String endLogradouro;
	
	@Getter
	@Setter
	private String endNumero;
	
	@Getter
	@Setter
	private String endBairro;
	
	@Getter
	@Setter
	private String endCidade;
	
	@Getter
	@Setter
	private String endEstado;
	
	@Getter
	@Setter
	private String endCep;
	
	public ClienteNewDTO() {
	}

}
