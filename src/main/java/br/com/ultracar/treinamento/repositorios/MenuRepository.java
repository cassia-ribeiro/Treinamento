package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Menu;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	
	@Query("Select m From Menu m where m.descricao = :descricao")
	public Menu findMenuByDescricao(String descricao);
	
	@Query("Select m From Menu m where m.url = :url")
	public Menu findMenuByUrl(String url);	
		
	//buscar todos os menu do usuario
	@Query("Select menu From Menu menu " 
			+ "Inner Join menu.permissaoAcesso permissaoAcesso "
			+ "Inner Join permissaoAcesso.grupoAcesso grupoAcesso " 
			+ "Inner Join grupoAcesso.usuario usuario "
			+ "Where usuario = :usuario")
	public List<Menu> findByUsuario(Usuario usuario);

}
