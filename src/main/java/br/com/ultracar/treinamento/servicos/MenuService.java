package br.com.ultracar.treinamento.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entidades.Menu;
import br.com.ultracar.treinamento.repositorios.MenuRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MenuService {
	
	@Autowired
	private MenuRepository repositorio;
	
	public void salvarMenu(Menu menu) {
		this.repositorio.save(menu);
	}
	
	public void deletarMenu(Menu menu) {
		this.repositorio.deleteById(menu.getId());
	} 
	
	public void deletarVariosMenu(List<Long> ids) {
		ids.parallelStream().forEach(id -> {
			if(this.repositorio.existsById(id)) {
				this.repositorio.deleteById(id);
			}
		});
	}	

}
