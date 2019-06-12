package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cidade")
	private Set<Bairro> bairro = new HashSet<>();
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name = "fk_cidade_estado"), nullable = false)
	private Estado estado;
	
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
