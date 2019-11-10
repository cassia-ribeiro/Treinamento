package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
	@SequenceGenerator(name = "categoria_sequence", sequenceName = "categoria_id_sequence", allocationSize = 1)
	@Column(name = "id_categoria", nullable = false)	
	private Long id;
	
	@Max(4)
	@NotBlank
	@Column(name = "ds_nome", nullable = false, length = 30)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
