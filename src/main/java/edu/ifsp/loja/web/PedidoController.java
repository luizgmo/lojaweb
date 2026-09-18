package edu.ifsp.loja.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Pedido;
import edu.ifsp.loja.modelo.PedidoItem;
import edu.ifsp.loja.persistencia.PedidoItemRepositorio;
import edu.ifsp.loja.persistencia.PedidoRepositorio;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepositorio repo;
    
    @Autowired
    private PedidoItemRepositorio itemRepo;    


    @GetMapping("/listar")
    public String pedidosCliente(Model model) {
        List<Pedido> pedidos = repo.findAll();

        model.addAttribute("pedidos", pedidos);

        return "pedido/listar";
    }
    
    @GetMapping("/{id}")
    public String detalhes(@PathVariable(name = "id") Integer id, Model model) {
        Pedido pedido = repo.findById(id).get();
        model.addAttribute("pedido", pedido);

        List<PedidoItem> itens = itemRepo.findByPedidoId(id); 
        model.addAttribute("itens", itens);


        return "pedido/detalhes";
    }    
}