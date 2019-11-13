//package br.com.ultracar.treinamento.servicos;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import br.com.ultracar.treinamento.entidades.Endereco;
//import br.com.ultracar.treinamento.repositorios.CepRepository;
//
//@Service
//@Transactional(propagation = Propagation.REQUIRED)
//public class CepService {
//	
//	@Autowired
//	private CepRepository repositorio;	
//	
//	public List<Endereco> findEnderecoByCep(String cep) {
//		return this.repositorio.findEnderecoByCep(cep);
//	}	
//
//}
