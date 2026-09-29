package edu.ifsp.loja.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.loja.modelo.Produto;
import edu.ifsp.loja.persistencia.ProdutoRepositorio;

@RestController
@RequestMapping(path = "/api/produto", produces = "application/json")
public class ProdutoRestController {
	@Autowired
	private ProdutoRepositorio repo;
	
	@GetMapping
	public List<Produto> listar() {
		return repo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
