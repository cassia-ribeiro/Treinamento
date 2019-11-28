package br.com.ultracar.treinamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.repositorios.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {
	
	@Autowired
	private CepRepository repositorio;	
	
	public Cep findCepByEndereco(String codigoPostal) {
		return this.repositorio.findCepByEndereco(codigoPostal);
	}	
	

	public Page<Cep> findAllCep(Cep cep, Pageable pageable) {
		return this.repositorio.findAllCep(cep, pageable);
	}		
	

}
