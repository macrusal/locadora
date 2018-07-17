package br.com.hibejix.locadora.services;

import br.com.hibejix.locadora.entities.Filme;
import br.com.hibejix.locadora.entities.Locacao;
import br.com.hibejix.locadora.entities.Usuario;
import br.com.hibejix.locadora.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LocacaoServiceTest {

    @Autowired
    private LocacaoService service;

    @Autowired
    private Locacao locacao;

    @Autowired
    private Filme filme;

    @Autowired
    private Usuario usuario;

    @Before
    public void inicializa() {
        service = new LocacaoService();
    }

    @Test
    public void teste() {

        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario();
        Filme filme = new Filme();

        //acao
        Locacao locacao = service.alugarFilme(obterUsuario(),obterFilme());

        //verificacao
        Assert.assertEquals(locacao.getValor(), new Double(5.0));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.adicionarDias(new Date(), 1)));
    }

    @Test
    public void o_nome_dop_filme_nao_deve_ser_vazio() {
        Locacao locacao = service.alugarFilme(obterUsuario(),obterFilme());
        Assert.assertThat(locacao.getFilme().getNome(), CoreMatchers.notNullValue());
    }

    @Test
    public void usuario_fez_locacao() {
        Locacao locacao = service.alugarFilme(obterUsuario(),obterFilme());
        Assert.assertNotNull(locacao.getUsuario());
    }

    @Test
    public void usuario_diferente_usuario_filho() {
        Locacao locacao = service.alugarFilme(obterUsuario(),obterFilme());
        Assert.assertNotSame(locacao.getUsuario(), obterUsuarioFilho());
    }

    private Usuario obterUsuario() {
        Usuario usuario = Usuario.builder()
                .id(1L)
                .nome("Locador da Silva")
                .build();
        return usuario;
    }

    private Usuario obterUsuarioFilho() {
        Usuario usuario = Usuario.builder()
                .id(1L)
                .nome("Locador da Silva Jr.")
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
