package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_bairro")
public class Bairro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro_sequence")
	@SequenceGenerator(name = "bairro_sequence", sequenceName = "bairro_id_sequence")
	@Column(name = "id_bairro", nullable = false)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 100)
	@Column(name = "ds_nome", nullable = false, length = 100)
	private String nome;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="tb_bairro_endereco", 
			joinColumns= {@JoinColumn(name="id_bairro", foreignKey = @ForeignKey(name = "fk_id_bairro_endereco"))},
			inverseJoinColumns= {@JoinColumn(name="id_endereco", foreignKey = @ForeignKey(name = "fk_id_endereco_bairro"))})
	private Set<Endereco> enderecos = new HashSet<>();		
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cidade", foreignKey = @ForeignKey(name = "fk_bairro_cidade"), nullable = false)
	private Cidade cidade;		

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
