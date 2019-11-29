package br.com.ultracar.treinamento.restcontroladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Estado;
import br.com.ultracar.treinamento.servicos.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public Page<Estado> findAllEstadoPage(Estado estado, Pageable pageable) {
		return estadoService.findAllEstadoPage(estado, pageable);
	}	

}
