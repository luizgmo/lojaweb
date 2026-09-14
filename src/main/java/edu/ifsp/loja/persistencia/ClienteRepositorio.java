package edu.ifsp.loja.persistencia;

import edu.ifsp.loja.modelo.Cliente;

public interface ClienteRepositorio {
	Cliente findById(int id);
	Cliente save(Cliente cliente);
	Iterable<Cliente> findAll();	
	void deleteById(int id);
}
