package edu.ifsp.loja.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifsp.loja.modelo.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
