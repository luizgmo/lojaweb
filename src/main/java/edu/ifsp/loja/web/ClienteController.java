package edu.ifsp.loja.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Cliente;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@GetMapping("/editar")
	public String iniciar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "editar";
	}
	
	@PostMapping("/editar")
	public String salvar(@Valid Cliente cliente, Errors errors) {
		if (errors.hasErrors()) {
			for (var e : errors.getAllErrors()) {
				System.out.println(e);
			}
			
			return "editar";
		}
		
		System.out.println("ClienteController.salvar()");
		System.out.println("ID: " + cliente.getId());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("E-mail: " + cliente.getEmail());
		return "redirect:/cliente/editar";
	}
	
	@GetMapping("/listar")
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
