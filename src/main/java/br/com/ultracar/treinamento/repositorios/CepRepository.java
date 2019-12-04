package br.com.ultracar.treinamento.repositorios;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Cep;


@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
	
	//buscar endereco de determinado CEP
	@Query(		"Select distinct c From Cep c "
			+   "Inner Join Fetch  c.endereco e "
			+   "Inner Join Fetch  e.bairros bai " 
			+   "Inner Join  bai.cidade cid "
			+   "Inner Join  cid.estado est "
			+ 	"Where c.codigoPostal = :codigoPostal")
	public Cep findCepByEndereco(@Param("codigoPostal") String codigoPostal);
	
//	@Query(		"Select c From Cep c "
//			+ 	"Where c.codigoPostal = :codigoPostal ")
//	public Cep findCepByEndereco(@Param("codigoPostal") String codigoPostal);
	
	@Query("Select c From Cep c ")	
	public Page<Cep> findAllCep(Cep cep, Pageable pageable);
	
	
	
}