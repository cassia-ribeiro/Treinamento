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

import br.com.ultracar.treinamento.entidades.enumeradores.Crud;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_operacao")
public class Operacao implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operacao_sequence")
	@SequenceGenerator(name = "operacao_sequence", sequenceName = "operacao_id_sequence", allocationSize = 1)
	@Column(name = "id_operacao", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "ds_descricao", nullable = false, length = 45)
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_operacao", nullable = false, length = 10)
	private Crud operacao;
	
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

	public Crud getOperacao() {
		return operacao;
	}

	public void setOperacao(Crud operacao) {
		this.operacao = operacao;
	}
	
	
	

}
