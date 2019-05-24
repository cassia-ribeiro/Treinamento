package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "ds_complemento", nullable = false, length = 255)
	private String complemento;
	
	@Column(name = "nm_numero")
	private Integer numero;	

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_tipo_local", nullable = false, length = 15)
	private TipoLocal tipoLocal;
	

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

	public TipoLocal getTipoLocal() {
		return tipoLocal;
	}

	public void setTipoLocal(TipoLocal tipoLocal) {
		this.tipoLocal = tipoLocal;
	}
	
	


}
