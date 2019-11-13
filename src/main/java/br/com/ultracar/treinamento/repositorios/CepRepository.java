//package br.com.ultracar.treinamento.repositorios;
//
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import br.com.ultracar.treinamento.entidades.Cep;
//import br.com.ultracar.treinamento.entidades.Endereco;
//
//
//@Repository
//public interface CepRepository extends JpaRepository<Cep, Long> {
//	
//
//	//buscar endereco de determinado CEP
//	@Query(		"Select endereco From Endereco endereco "
//			+ 	"Inner Join endereco.id enderecoid "
//			+ 	"Where enderecoid.cep = :codigoPostal")
//	public List<Endereco> findEnderecoByCep(String codigoPostal);	
//
//}