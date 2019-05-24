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
@Table(name = "tb_menu")
public class Menu implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_sequence")
	@SequenceGenerator(name = "menu_sequence", sequenceName = "menu_id_sequence", allocationSize = 1)
	@Column(name = "id_menu", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "ds_descricao", nullable = false, length = 45)	
	private String descricao;
	
	@NotBlank
	@Size(min = 5, max = 150)
	@Column(name = "ds_url", nullable = false, length = 150)	
	private String url;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "ds_icone", nullable = false, length = 45)	
	private String icone;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "ds_indice", nullable = false, length = 45)	
	private String indice;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}


}
