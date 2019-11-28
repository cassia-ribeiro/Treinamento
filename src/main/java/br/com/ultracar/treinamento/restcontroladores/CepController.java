package br.com.ultracar.treinamento.restcontroladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.servicos.CepService;

@RestController
@RequestMapping("/api/cep")
public class CepController {

	@Autowired
	private CepService cepService;
	
	@GetMapping("/{cep}")
	public ResponseEntity<Cep> pesquisaPorCep(@PathVariable String codigoPostal) {
		Cep cep = cepService.findCepByEndereco(codigoPostal);
		 return cep != null ? ResponseEntity.ok(cep) : ResponseEntity.notFound().build();
	}		
	
	
	@GetMapping
	public Page<Cep> findAllCep(Cep cep,  Pageable pageable) {
		return cepService.findAllCep(cep, pageable);
	}	
}
