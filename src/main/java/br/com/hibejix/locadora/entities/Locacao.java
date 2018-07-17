package br.com.hibejix.locadora.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Locacao {

	@Id
	private Long id;
	private Usuario usuario;
	private Filme filme;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;
}