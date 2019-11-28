package br.com.ultracar.treinamento.repositorios;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.Usuario;


@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
	
	//buscar endereco de determinado CEP
//	@Query(		"Select c From Cep c "
//			+   "Inner Join c.endereco end "
//			+   "Inner Join end.bairros bai " 
//			+   "Inner Join bai.cidade cid "
//			+   "Inner Join cid.estado est "
//			+ 	"Where c.cep = :codigoPostal")
//	public Cep findCepByEndereco(String codigoPostal);
	
	@Query(		"Select c From Cep c "
			+ 	"Where c.cep = :codigoPostal ")
	public Cep findCepByEndereco(String codigoPostal);
	
	@Query("Select c From Cep c ")	
	public Page<Cep> findAllCep(Cep cep, Pageable pageable);
	
	
	
}