package edu.ifsp.loja.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifsp.loja.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{

}
