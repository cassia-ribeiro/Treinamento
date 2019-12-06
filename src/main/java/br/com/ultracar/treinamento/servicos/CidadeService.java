package br.com.ultracar.treinamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.repositorios.CidadeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class CidadeService {
	
	@Autowired
	private CidadeRepository repositorio;
	
	public Cidade findByNomeExato(String nome) {
		return this.repositorio.findByNomeExato(nome);
	}	
	
	

}
