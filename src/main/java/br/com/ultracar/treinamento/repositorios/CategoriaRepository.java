package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ultracar.treinamento.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {
	
	

}
