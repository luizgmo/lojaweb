package edu.ifsp.loja.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import edu.ifsp.loja.modelo.Cliente;

@Repository
public class ClienteRepositorioJdbc implements ClienteRepositorio {
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Cliente findById(long id) {
		return jdbc.queryForObject(
				"SELECT id, nome, email, ativo FROM cliente WHERE id = ?", 
				this::mapRow, id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		
		if (cliente.getId() == 0) {
			insert(cliente);
		} else {
			update(cliente);
		}
		
		return cliente;
	}

	private void update(Cliente cliente) {
		jdbc.update("UPDATE cliente SET nome = ?, email = ? WHERE id = ?",
				cliente.getNome(),
				cliente.getEmail(),
				cliente.getId());
	}

	private void insert(Cliente cliente) {
		KeyHolder holder = new GeneratedKeyHolder(); 

		jdbc.update(conn -> {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO cliente (nome, email) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			return ps;
			}, holder);
		
		cliente.setId(holder.getKey().longValue());		
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
