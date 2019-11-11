package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ultracar.treinamento.entidades.enumeradores.TipoLocal;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
	@SequenceGenerator(name = "endereco_sequence", sequenceName = "endereco_id_sequence")
	@Column(name = "id_endereco", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 128)
	@Column(name = "ds_logradouro", nullable = false, length = 128)
	private String logradouro;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_tipo_local", nullable = false, length = 15)
	private TipoLocal tipoLocal;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Ponto> ponto =  new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Solicitante> solicitante =  new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Cep> cep =  new HashSet<>();	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="tb_endereco_bairro", 
			joinColumns= {@JoinColumn(name="id_endereco", foreignKey = @ForeignKey(name = "fk_id_endereco_bairro"))},
			inverseJoinColumns= {@JoinColumn(name="id_bairro", foreignKey = @ForeignKey(name = "fk_id_bairro_endereco"))})
	private Set<Bairro> bairros = new HashSet<>();	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="tb_servico", 
			joinColumns= {@JoinColumn(name="id_solicitante", foreignKey = @ForeignKey(name = "fk_servico_solicitante"))},
			inverseJoinColumns= {@JoinColumn(name="id_endereco", foreignKey = @ForeignKey(name = "fk_servico_endereco"))})
	private Set<Solicitante> servicos = new HashSet<>();	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
/*
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
*/
	public TipoLocal getTipoLocal() {
		return tipoLocal;
	}

	public void setTipoLocal(TipoLocal tipoLocal) {
		this.tipoLocal = tipoLocal;
	}
	
	


}
