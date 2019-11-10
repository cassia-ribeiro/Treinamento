package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_complemento_endereco")
@Data
public class ComplementoEndereco implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complemento_endereco_sequence")
	@SequenceGenerator(name = "complemento_endereco_sequence", sequenceName = "complemento_endereco_id_sequence", allocationSize = 1)
	@Column(name = "id_complemento_endereco", nullable = false)
	private Long id;

	@Column(name = "nm_numero")
	private Integer numero;	
		
	@Column(name = "ds_complemento", nullable = false, length = 255)
	private String complemento;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "fk_complemento_endereco"), nullable = false)
	private Endereco endereco;	
	
}
