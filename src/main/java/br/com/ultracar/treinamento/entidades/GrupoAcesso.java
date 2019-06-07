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
@Table(name = "tb_grupo_acesso")
public class GrupoAcesso implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_acesso_sequence")
	@SequenceGenerator(name = "grupo_acesso_sequence", sequenceName = "grupo_acesso_id_sequence", allocationSize = 1)
	@Column(name = "id_grupo_acesso", nullable = false)	
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "ds_descricao")
	private String descricao;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
