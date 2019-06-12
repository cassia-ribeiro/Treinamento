package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	
	@Query("Select m From Menu m where m.descricao = :descricao")
	public Menu findMenyByDescricao(String descricao);
	
	@Query("Select m From Menu m where m.url = :url")
	public Menu findMenuByUrl(String url);	

}
