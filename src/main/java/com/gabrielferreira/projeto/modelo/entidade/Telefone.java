package com.gabrielferreira.projeto.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gabrielferreira.projeto.modelo.entidade.enums.TipoTelefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tab_telefone")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Telefone não pode ser vazio")
	@Column(name="numero",nullable = false)
	private String nome;
	
	@ManyToOne()
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@Valid
	@NotNull(message = "Tem que selecionar o tipo de telefone")
	@Enumerated(EnumType.STRING)
	private TipoTelefone  tipoTelefone;
	
	public Telefone() {}

	public Telefone(Integer id, String nome,TipoTelefone tipoTelefone) {
		this.id = id;
		this.nome = nome;
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
