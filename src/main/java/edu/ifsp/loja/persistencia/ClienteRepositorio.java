package edu.ifsp.loja.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifsp.loja.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	
}
