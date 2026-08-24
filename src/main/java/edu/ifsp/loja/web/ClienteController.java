package edu.ifsp.loja.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ifsp.loja.modelo.Cliente;

@Controller
public class ClienteController {
	
	@GetMapping("/cliente/listar")
	public String listar(Model model) {
		// simulando consulta ao banco de dados
		List<Cliente> clientes = List.of(
				new Cliente(1, "Juvenal Junqueira", true),
				new Cliente(2, "Francisco Fernandes", false),
				new Cliente(3, "Mário Martins", true),
				new Cliente(4, "Antônio Antunes", true)
				);
		
		model.addAttribute("clientes", clientes);
				
		return "listar";
	}
}
