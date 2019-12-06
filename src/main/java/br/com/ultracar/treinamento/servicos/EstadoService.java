package br.com.ultracar.treinamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entidades.Estado;
import br.com.ultracar.treinamento.repositorios.EstadoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EstadoService {
	
	@Autowired
	private EstadoRepository repositorio;
	
	public Page<Estado> findAllEstadoPage(Estado estado, Pageable pageable) {
		return this.repositorio.findAllEstado(estado, pageable);
	}	
		
	public Estado findByUf(String uf) {
		return this.findByUf(uf);
	}
}
