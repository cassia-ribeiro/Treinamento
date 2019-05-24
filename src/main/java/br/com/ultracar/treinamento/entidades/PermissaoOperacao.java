package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_permissao_operacao")
public class PermissaoOperacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_operacao_sequence")
	@SequenceGenerator(name = "permissao_operacao_sequence", sequenceName = "permissao_operacao_id_sequence", allocationSize = 1)
	@Column(name = "id_permissao_acesso", nullable = false)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
