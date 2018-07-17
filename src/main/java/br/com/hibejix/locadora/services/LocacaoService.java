package br.com.hibejix.locadora.services;


import br.com.hibejix.locadora.entities.Filme;
import br.com.hibejix.locadora.entities.Locacao;
import br.com.hibejix.locadora.entities.Usuario;
import br.com.hibejix.locadora.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LocacaoService {

	@Autowired
	private Locacao locacao;

	@Autowired
	private Filme filme;

	@Autowired
	private Usuario usuario;
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date dataLocacao = new Date(System.currentTimeMillis());
		Locacao locacao = Locacao.builder()
				.filme(obterFilme())
				.dataLocacao(dataLocacao)
				.dataRetorno(DataUtils.adicionarDias(new Date(), 1))
				.usuario(obterUsuario())
				.valor(5.0)
				.build();
		return locacao;
	}

	private Usuario obterUsuario() {
		Usuario usuario = Usuario.builder()
				.id(1L)
				.nome("Locador da Silva")
				.build();
		return usuario;
	}

	private Filme obterFilme() {
		Filme filme = Filme.builder()
				.id(1L)
				.estoque(10)
				.nome("Os Piratas do Vale do Silício")
				.precoLocacao(5.0)
				.build();

		return filme;
	}
}