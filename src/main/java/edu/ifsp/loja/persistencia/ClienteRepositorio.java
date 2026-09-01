package edu.ifsp.loja.persistencia;

import edu.ifsp.loja.modelo.Cliente;

public interface ClienteRepositorio {
	Cliente findById(long id);
	Cliente save(Cliente cliente);
	Iterable<Cliente> findAll();
}
