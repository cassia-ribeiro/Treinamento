package br.com.ultracar.treinamento.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Cep;
import br.com.ultracar.treinamento.entidades.Endereco;
import br.com.ultracar.treinamento.entidades.Operacao;
import br.com.ultracar.treinamento.entidades.Usuario;


@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
	

	//buscar endereco de determinado CEP
	@Query(		"Select distinct enderecos From Endereco endereco "
			+   "Inner Join endereco.bairros bairros " 
			+   "Inner Join bairros.enderecos enderecos "
			+   "Inner Join endereco.cep cep "
			+ 	"Where cep.cep = :codigoPostal")
	public Endereco findEnderecoByCep(String codigoPostal);	
	
}