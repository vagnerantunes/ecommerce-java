package com.app.ecommerce.dto;

import java.io.Serializable;

import com.app.ecommerce.entities.Cliente;
import com.app.ecommerce.enums.AtivoBloqStatus;
import com.app.ecommerce.enums.TipoCliente;

import lombok.Getter;
import lombok.Setter;

public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Integer cliId;

	@Getter
	@Setter
	private String cliNome;
	
	@Getter
	@Setter
	private String cliCelular;
	
	@Getter
	@Setter
	private TipoCliente cliTipo;
	
	@Getter
	@Setter
	private String cliCpfCnpj;
	
	@Getter
	@Setter
	private String cliEmail;
	
	@Getter
	@Setter
	private AtivoBloqStatus cliStatus;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente obj) {
		cliId = obj.getCliId();
		cliNome = obj.getCliNome();
		cliCelular = obj.getCliCelular();
		cliTipo = obj.getCliTipo();
		cliCpfCnpj = obj.getCliCpfCnpj();
		cliEmail = obj.getCliEmail();
		cliStatus = obj.getCliStatus();
	}

}
