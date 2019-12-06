package br.com.ultracar.treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.dto.EnderecoDTO;
import br.com.ultracar.treinamento.servicos.CepService;

@RestController
@RequestMapping("/api/cep")
public class CepController {

	@Autowired
	private CepService cepService;
	
	@GetMapping
	public Page<Cep> findAllCep(Cep cep, Pageable pageable) {
		return cepService.findAllCep(cep, pageable);
	}		

	@GetMapping(value = "/{codigoPostal}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> pesquisaPorCep(@PathVariable(name = "codigoPostal", required = true) String codigoPostal) {
		Cep cep = cepService.findCepByEndereco(codigoPostal);
		return new ResponseEntity<>(cep, HttpStatus.OK);
	}

	
//	@GetMapping("/{cep}")
//	public ResponseEntity<Cep> pesquisaPorCep(@PathVariable String codigoPostal) {
//		Cep cep = cepService.findCepByEndereco(codigoPostal);
//		 return cep != null ? ResponseEntity.ok(cep) : ResponseEntity.notFound().build();
//	}		
	

}
