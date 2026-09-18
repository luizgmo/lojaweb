package edu.ifsp.loja.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifsp.loja.modelo.PedidoItem;

public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, Integer> {
    List<PedidoItem> findByPedidoId(Integer id); 
}