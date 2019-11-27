package br.com.ultracar.treinamento.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Cep;


@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
	

	//buscar endereco de determinado CEP
	@Query(		"Select cep From Cep cep "
			+   "Inner Join cep.endereco end "
			+   "Inner Join end.bairros bai " 
			+   "Inner Join bai.cidade cid "
			+   "Inner Join cid.estado est "
			+ 	"Where c.cep = :codigoPostal")
	public Cep findCepByEndereco(String codigoPostal);
	
	
	
}