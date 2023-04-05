package com.app.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "END_ID")
	private Integer endId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "END_CLI_ID")
	private Cliente endCliId;
	
	@Column(name = "END_LOGRADOURO")
	private String endLogradouro;
	
	@Column(name = "END_NUMERO")
	private String endNumero;
	
	@Column(name = "END_BAIRRO")
	private String endBairro;
	
	@Column(name = "END_CIDADE")
	private String endCidade;
	
	@Column(name = "END_ESTADO")
	private String endEstado;
	
	@Column(name = "END_CEP")
	private String endCep;

}
