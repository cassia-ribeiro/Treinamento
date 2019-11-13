//package br.com.ultracar.treinamento.restcontroladores;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.ultracar.treinamento.entidades.Endereco;
//import br.com.ultracar.treinamento.servicos.CepService;
//
//@RestController
//@RequestMapping("/api/cep")
//public class CepController {
//
//	@Autowired
//	private CepService cepService;
//	
//	@GetMapping("/{cep}")
//	public ResponseEntity<Endereco> buscarPeloCep(@PathVariable String cep) {
//		Endereco endereco = (Endereco) cepService.findEnderecoByCep(cep);
//		 return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
//	}			
//}
