package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Estado;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query("select est From Estado est")
	public Page<Estado> findAllEstado(Estado estado, Pageable pageable);

}
