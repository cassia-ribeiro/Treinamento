package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Bairro;
import br.com.ultracar.treinamento.entidades.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	@Query("Select cidade From Cidade cidade where cidade.nome Like %?1% ")
	public List<Cidade> findByNome(String nome);
	
	@Query("Select cidade From Cidade cidade where cidade.nome = :nome ")
	public Cidade findByNomeExato(String nome);
	
	@Query("Select b From Bairro b where b.cidade = :cidade ")
	public List<Bairro> findCidadeByBairro(Cidade cidade);

	@Query(		"Select b From Bairro b "
			+ 	"Inner Join b.cidade c "
			+	"Where c.id = :idCidade ")
	public List<Bairro> findCidadeByBairro(@Param("idCidade") Long id);
	
	//buscar todas as cidades de MG
	@Query(		"Select cidade From Cidade cidade "
			+ 	"Inner Join cidade.estado estado "
			+ 	"Where estado.sigla = :siglaEstado")
	public List<Cidade> findByEstado(String siglaEstado);
	
}
