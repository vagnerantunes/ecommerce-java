package com.app.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecommerce.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}