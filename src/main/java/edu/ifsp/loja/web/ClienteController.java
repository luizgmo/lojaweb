package edu.ifsp.loja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Cliente;
import edu.ifsp.loja.persistencia.ClienteRepositorio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepositorio repo;
	
	@GetMapping("/novo")
	public String iniciar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/editar";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, Errors errors) {
		if (errors.hasErrors()) {
			for (var e : errors.getAllErrors()) {
				System.out.println(e);
			}
			
			return "cliente/editar";
		}
		
		System.out.println("ClienteController.salvar()");
		System.out.println("ID: " + cliente.getId());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("E-mail: " + cliente.getEmail());
		return "redirect:/cliente/novo";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		Iterable<Cliente> clientes = repo.findAll();
		
		model.addAttribute("clientes", clientes);
				
		return "cliente/listar";
	}
}
