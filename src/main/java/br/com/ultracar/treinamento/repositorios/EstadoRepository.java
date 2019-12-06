package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.Estado;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query("select est From Estado est")
	public Page<Estado> findAllEstado(Estado estado, Pageable pageable);
	
	//buscar endereco de determinado CEP
	@Query(		"Select est From Estado est "
			+ 	"Where est.sigla = :uf")
	public Cep findCepByEndereco(String uf);


}
