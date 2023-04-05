package com.app.ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;

import com.app.ecommerce.enums.AtivoBloqStatus;
import com.app.ecommerce.enums.TipoCliente;

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
	@OneToMany(mappedBy="endCliId", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@Getter
	@Setter
	@Column(length = 45, name = "CLI_NOME")
	private String cliNome;
	
	@Getter
	@Setter
	@Column(length = 15, name = "CLI_CELULAR")
	private String cliCelular;
	
	@Column(name = "CLI_TIPO")
	private Integer cliTipo;
	
	@Getter
	@Setter
	@CPF
	@Column(name = "CLI_CPF_CNPJ", unique = true)
	private String cliCpfCnpj;
	
	@Getter
	@Setter
	@Column(name = "CLI_EMAIL", unique = true)
	private String cliEmail;
	
	@Column(name = "CLI_STATUS")
	private Integer cliStatus;

	public Cliente() {
	}

	public Cliente(Integer cliId, String cliNome, String cliCelular,TipoCliente cliTipo,String cliCpfCnpj, String cliEmail, AtivoBloqStatus cliStatus) {
		super();
		this.cliId = cliId;
		this.cliNome = cliNome;
		this.cliCelular = cliCelular;
		this.cliTipo = (cliTipo==null) ? null : cliTipo.getCod();
		this.cliCpfCnpj = cliCpfCnpj;
		this.cliEmail = cliEmail;
		this.cliStatus = (cliStatus==null) ? null : cliStatus.getCod();
	}
	
	public AtivoBloqStatus getCliStatus() {
		return AtivoBloqStatus.toEnum(cliStatus);
	}

	public void setCliStatus(AtivoBloqStatus cliStatus) {
		this.cliStatus = cliStatus.getCod();
	}
	
	public TipoCliente getCliTipo() {
		return TipoCliente.toEnum(cliStatus);
	}

	public void setCliTipo(TipoCliente cliStatus) {
		this.cliStatus = cliStatus.getCod();
	}
}