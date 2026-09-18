package edu.ifsp.loja.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Pedido;
import edu.ifsp.loja.persistencia.PedidoRepositorio;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepositorio repo;


    @GetMapping("/listar")
    public String pedidosCliente(Model model) {
        List<Pedido> pedidos = repo.findAll();

        model.addAttribute("pedidos", pedidos);

        return "pedido/listar";
    }
}