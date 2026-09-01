package edu.ifsp.loja.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.ifsp.loja.modelo.Cliente;

@Repository
public class ClienteRepositorioJdbc implements ClienteRepositorio {
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Cliente findById(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Cliente save(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Cliente> findAll() {
		return jdbc.query(
				"SELECT id, nome, email, ativo FROM cliente ORDER BY nome", 
				this::mapRow);
	}
	
	private Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getLong("id"));
		cliente.setNome(rs.getString("nome"));
		cliente.setEmail(rs.getString("email"));
		cliente.setAtivo(rs.getBoolean("ativo"));
		return cliente;
	}

}
