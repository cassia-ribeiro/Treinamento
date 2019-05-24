package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_sequence")
	@SequenceGenerator(name = "cidade_sequence", sequenceName = "cidade_id_sequence")
	@Column(name = "id_cidade", nullable = false)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 38)
	@Column(name = "ds_nome", nullable = false, length = 38)
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
