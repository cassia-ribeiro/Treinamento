package br.com.ultracar.treinamento.restcontroladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Categoria;
import br.com.ultracar.treinamento.repositorios.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public void criar(@RequestBody Categoria categoria) {
		
		categoriaRepository.save(categoria);
	}
	
	
	
}
