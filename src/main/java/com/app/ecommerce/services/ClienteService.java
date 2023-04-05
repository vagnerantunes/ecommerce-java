package com.app.ecommerce.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecommerce.dto.ClienteDTO;
import com.app.ecommerce.dto.ClienteNewDTO;
import com.app.ecommerce.entities.Cliente;
import com.app.ecommerce.entities.Endereco;
import com.app.ecommerce.enums.AtivoBloqStatus;
import com.app.ecommerce.repositories.ClienteRepository;
import com.app.ecommerce.repositories.EnderecoRepository;
import com.app.ecommerce.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente insert(Cliente obj) {
		obj.setCliId(null);
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public void delete(Integer id) {
			repository.deleteById(id);
	}
	
	public Cliente update(Integer id, Cliente obj) {
		try {
			Cliente entity = findById(obj.getCliId());
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Cliente entity, Cliente obj) {
		entity.setCliNome(obj.getCliNome());
		entity.setCliCelular(obj.getCliCelular());
		entity.setCliCpfCnpj(obj.getCliCpfCnpj());
		entity.setCliEmail(obj.getCliEmail());
		entity.setCliStatus(obj.getCliStatus());
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getCliId(), objDto.getCliNome(), objDto.getCliCelular(), objDto.getCliCpfCnpj(),
				objDto.getCliEmail(), objDto.getCliStatus());
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getCliNome(), objDto.getCliCelular(), objDto.getCliCpfCnpj(), objDto.getCliEmail(),
				AtivoBloqStatus.toEnum(objDto.getCliStatus()));

		Endereco end = new Endereco(null, cli, objDto.getEndLogradouro(), objDto.getEndNumero(),
				 objDto.getEndBairro(), objDto.getEndCidade(), objDto.getEndEstado(), objDto.getEndCep());
		
		cli.getEnderecos().add(end);
		return cli;
	}

}
