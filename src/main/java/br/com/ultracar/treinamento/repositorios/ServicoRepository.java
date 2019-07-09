package br.com.ultracar.treinamento.repositorios;

import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Servico;
import br.com.ultracar.treinamento.entidades.Solicitante;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	//Exemplo - Atualizar todos os servicos que tenham o solicitante 2 para 3
	@Modifying
	//?1 = refere-se ao primeiro paramentro, ?2 = segundo paramentro
	@Query("Update Servico s Set s.solicitante.id = ?1 Where s.solicitante.id = ?2 ")
	Integer updateAllBySolicitante(Long novoSolicitante, Long antigoSolicitante);

	//Atualizar todos os servicos que tenham o solicitante 2 para 3
	@Modifying
	@Query("Update Servico s Set s.solicitante = ?1 Where s.solicitante.id = ?2 ")
	Integer updateAllBySolicitante(Solicitante solicitante, Long antigoSolicitante);
/*	
	//Buscar de forma assincrona todos os servicos da operacao de incluir
	@Async
	@Query("Select  ")
	public Future<Servico> findByServicoOperacaoIncluir();	
*/	
}
