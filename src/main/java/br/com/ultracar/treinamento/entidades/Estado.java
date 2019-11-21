package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_sequence")
	@SequenceGenerator(name = "estado_sequence", sequenceName = "estado_id_sequence", allocationSize = 1)
	@Column(name = "id_estado", nullable = false)	
	private Long id;
	
	@Max(2)
	@NotBlank
	@Column(name = "ds_sigla", nullable = false)
	private String sigla;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	private Set<Cidade> cidade = new HashSet<>();	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Set<Cidade> getCidade() {
		return cidade;
	}

	public void setCidade(Set<Cidade> cidade) {
		this.cidade = cidade;
	}	

}
