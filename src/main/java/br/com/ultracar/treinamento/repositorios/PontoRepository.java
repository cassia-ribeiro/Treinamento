package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.entidades.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long>{

	@Query("Select ponto From Ponto ponto "
			+ "Inner Join ponto.endereco endereco "
			+ "Inner Join endereco.bairro bairro "
			+ "Inner Join bairro.cidade cidade "
			+ "Where cidade = :cidade")	
	public boolean findByPontoCidade (Cidade cidade);

	
	/*	//excluir todos os pontos de uma cidade
	@Modifying
	@Query("Delete From Ponto ponto "
			+ "Inner Join ponto.endereco endereco "
			+ "Inner Join endereco.bairro bairro "
			+ "Inner Join bairro.cidade cidade "
			+ "Where cidade = :cidade")		
	void deleteByPontoCidade(Cidade cidade);
		*/
}