package br.com.hibejix.locadora.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

	@Id
	private Long id;
	private String nome;
	private Integer estoque;
	private Double precoLocacao;  
}