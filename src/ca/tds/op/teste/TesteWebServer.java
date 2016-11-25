/**
 * 
 */
package ca.tds.op.teste;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.tds.op.dto.CategoriaDTO;
import ca.tds.op.dto.ItemDTO;
import ca.tds.op.dto.ListaCompraDTO;
import ca.tds.op.dto.LojaDTO;
import ca.tds.op.dto.PessoaDTO;
import ca.tds.op.dto.ProdutoDTO;
import ca.tds.op.model.Categoria;
import ca.tds.op.model.Item;
import ca.tds.op.model.ListaCompra;
import ca.tds.op.model.Loja;
import ca.tds.op.model.Pessoa;
import ca.tds.op.model.Produto;
import ca.tds.op.util.JsonUtil;

/**
 * @author Thanatos
 *
 */
public class TesteWebServer 
{
	
	private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy");
    private static String sUrlAplicacaoWS = "http://localhost:9999/LISTBUY_/WS";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, ParseException, IOException 
	{
		//Teste Um e comente outro
		
		Categoria();
		
		//Item();
		
		//ListaCompra();
		
		//Loja();
		
		//Pessoa();
		
		//Produto();
		
	}
	
	
	//METODOS
	//TODO
	public static void Categoria() throws ParseException, JsonParseException, JsonMappingException, IOException
	{
		// Objeto para conversao JSON <---> Java
        ObjectMapper tConversorJsonJava = new ObjectMapper();

        // Matrícula salva para uso no teste
        int tId = 0;

        /*   Teste de Inclusão de aluno */

        // Criando o aluno para teste
        Categoria tCategoria1 = new Categoria();
        tCategoria1.setNome("Categoria Web Server");

        // Convertendo o objeto para JSON
        String tCategoriaJson = tConversorJsonJava.writeValueAsString(tCategoria1);
        System.out.println("Categoria convertido em JSON");
        System.out.println(tCategoriaJson);

        // Chamando e Web Service de cadastramento
        System.out.println();
        String tResultado1 = JsonUtil.enviarPost(sUrlAplicacaoWS + "/Categoria/Cadastrar", tCategoriaJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado1);

        System.out.println("Resposta Convertida");
        CategoriaDTO tDto1 = tConversorJsonJava.readValue(tResultado1, CategoriaDTO.class);
        if (tDto1.isOk())
        {
            // Recuperando o aluno retornado e salvando a matrícula gerada
            Categoria tCategoriaRet = tDto1.getCategoria();
            tId = tCategoriaRet.getIdCategoria();

            System.out.println("Categoria Criado");
            System.out.println("Matrícula gerada : " + tId);
            System.out.println(tCategoria1);
        }
        else
            System.out.println(tDto1.getMensagem());

        /*   Teste de Recuperação de aluno */

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado2 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Categoria/Recuperar/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado2);

        System.out.println("Resposta Convertida");
        CategoriaDTO tDto2 = tConversorJsonJava.readValue(tResultado2, CategoriaDTO.class);
        if (tDto2.isOk())
        {
            // Recuperando o aluno retornado
            Categoria tCategoriaRet = tDto2.getCategoria();

            System.out.println("Categoria Recuperado");
            System.out.println(tCategoriaRet);
        }
        else
            System.out.println(tDto2.getMensagem());

        /*   Teste de Alteração de aluno */

        // Atualizando o aluno
        System.out.println();
        tCategoria1.setIdCategoria(tId);
        tCategoria1.setNome("Categoria atualizada");

        // Convertendo o objeto para JSON
        tCategoriaJson = tConversorJsonJava.writeValueAsString(tCategoria1);
        System.out.println("Categoria convertido em JSON");
        System.out.println(tCategoriaJson);

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado3 = JsonUtil.enviarPut(sUrlAplicacaoWS + "/Categoria/Atualizar", tCategoriaJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado3);

        System.out.println("Resposta Convertida");
        CategoriaDTO tDto3 = tConversorJsonJava.readValue(tResultado3, CategoriaDTO.class);
        if (tDto3.isOk())
        {
            // Recuperando o aluno retornado
            Categoria tCategoriaRet = tDto3.getCategoria();

            System.out.println("Categoria Atualizado");
            System.out.println(tCategoriaRet);
        }
        else
            System.out.println(tDto3.getMensagem());

        /*   Teste de Remoção de aluno */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado4 = JsonUtil.enviarDelete(sUrlAplicacaoWS + "/Categoria/Remover/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado4);

        System.out.println("Resposta Convertida");
        CategoriaDTO tDto4 = tConversorJsonJava.readValue(tResultado4, CategoriaDTO.class);
        if (tDto4.isOk())
        {
            System.out.println("Categoria Removido");
            System.out.println(tCategoria1);
        }
        else
            System.out.println(tDto4.getMensagem());

        /*   Teste da Pesquisa Geral de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado5 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Categoria/Pesquisar");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado5);

        System.out.println("Resposta Convertida");
        CategoriaDTO tDto5 = tConversorJsonJava.readValue(tResultado5, CategoriaDTO.class);
        if (tDto5.isOk())
        {
            // Recuperando a lista de alunos
            List<Categoria> tLista1 = tDto5.getLista();

            System.out.println("Categorias cadastrados no sistema");
            for (Categoria tCategoria : tLista1)
            {
                System.out.println(tCategoria);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por nome de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado6 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Categoria/PesquisarPorNome/a");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado6);

        System.out.println("Resposta Convertida");
        CategoriaDTO tDto6 = tConversorJsonJava.readValue(tResultado6, CategoriaDTO.class);
        if (tDto6.isOk())
        {
            // Recuperando a lista de alunos
            List<Categoria> tLista1 = tDto6.getLista();

            System.out.println("Categorias cadastrados no sistema como nome 'a'");
            for (Categoria tCategoria : tLista1)
            {
                System.out.println(tCategoria);
            }
        }
        else
            System.out.println(tDto4.getMensagem());
	}
	
	//TODO
	public static void Item() throws ParseException, JsonParseException, JsonMappingException, IOException
	{
		// Objeto para conversao JSON <---> Java
        ObjectMapper tConversorJsonJava = new ObjectMapper();

        // Matrícula salva para uso no teste
        int tId = 0;

        /*   Teste de Inclusão de aluno */

        // Criando o aluno para teste
        Item tItem1 = new Item();
        tItem1.setPreco(23.00);
        tItem1.setDesconto(0.10);
        tItem1.setQuantidade(1);

        // Convertendo o objeto para JSON
        String tItemJson = tConversorJsonJava.writeValueAsString(tItem1);
        System.out.println("Item convertido em JSON");
        System.out.println(tItemJson);

        // Chamando e Web Service de cadastramento
        System.out.println();
        String tResultado1 = JsonUtil.enviarPost(sUrlAplicacaoWS + "/Item/Cadastrar", tItemJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado1);

        System.out.println("Resposta Convertida");
        ItemDTO tDto1 = tConversorJsonJava.readValue(tResultado1, ItemDTO.class);
        if (tDto1.isOk())
        {
            // Recuperando o aluno retornado e salvando a matrícula gerada
            Item tItemRet = tDto1.getItem();
            tId = tItemRet.getIdItem();

            System.out.println("Item Criado");
            System.out.println("Matrícula gerada : " + tId);
            System.out.println(tItem1);
        }
        else
            System.out.println(tDto1.getMensagem());

        /*   Teste de Recuperação de aluno */

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado2 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Item/Recuperar/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado2);

        System.out.println("Resposta Convertida");
        ItemDTO tDto2 = tConversorJsonJava.readValue(tResultado2, ItemDTO.class);
        if (tDto2.isOk())
        {
            // Recuperando o aluno retornado
            Item tItemRet = tDto2.getItem();

            System.out.println("Item Recuperado");
            System.out.println(tItemRet);
        }
        else
            System.out.println(tDto2.getMensagem());

        /*   Teste de Alteração de aluno */

        // Atualizando o aluno
        System.out.println();
        tItem1.setIdItem(tId);
        tItem1.setPreco(23.00);
        tItem1.setDesconto(0.10);
        tItem1.setQuantidade(1);

        // Convertendo o objeto para JSON
        tItemJson = tConversorJsonJava.writeValueAsString(tItem1);
        System.out.println("Item convertido em JSON");
        System.out.println(tItemJson);

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado3 = JsonUtil.enviarPut(sUrlAplicacaoWS + "/Item/Atualizar", tItemJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado3);

        System.out.println("Resposta Convertida");
        ItemDTO tDto3 = tConversorJsonJava.readValue(tResultado3, ItemDTO.class);
        if (tDto3.isOk())
        {
            // Recuperando o aluno retornado
            Item tItemRet = tDto3.getItem();

            System.out.println("Item Atualizado");
            System.out.println(tItemRet);
        }
        else
            System.out.println(tDto3.getMensagem());

        /*   Teste de Remoção de aluno */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado4 = JsonUtil.enviarDelete(sUrlAplicacaoWS + "/Item/Remover/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado4);

        System.out.println("Resposta Convertida");
        ItemDTO tDto4 = tConversorJsonJava.readValue(tResultado4, ItemDTO.class);
        if (tDto4.isOk())
        {
            System.out.println("Item Removido");
            System.out.println(tItem1);
        }
        else
            System.out.println(tDto4.getMensagem());

        /*   Teste da Pesquisa Geral de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado5 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Item/Pesquisar");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado5);

        System.out.println("Resposta Convertida");
        ItemDTO tDto5 = tConversorJsonJava.readValue(tResultado5, ItemDTO.class);
        if (tDto5.isOk())
        {
            // Recuperando a lista de alunos
            List<Item> tLista1 = tDto5.getLista();

            System.out.println("Items cadastrados no sistema");
            for (Item tItem : tLista1)
            {
                System.out.println(tItem);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por nome de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado6 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Item/PesquisarPorNome/silva");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado6);

        System.out.println("Resposta Convertida");
        ItemDTO tDto6 = tConversorJsonJava.readValue(tResultado6, ItemDTO.class);
        if (tDto6.isOk())
        {
            // Recuperando a lista de alunos
            List<Item> tLista1 = tDto6.getLista();

            System.out.println("Items cadastrados no sistema como nome 'silva'");
            for (Item tItem : tLista1)
            {
                System.out.println(tItem);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por email de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado7 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Item/PesquisarPorEmail/@outlook");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado7);

        System.out.println("Resposta Convertida");
        ItemDTO tDto7 = tConversorJsonJava.readValue(tResultado7, ItemDTO.class);
        if (tDto7.isOk())
        {
            // Recuperando a lista de alunos
            List<Item> tLista1 = tDto7.getLista();

            System.out.println("Items cadastrados no sistema com email '@outlook'");
            for (Item tItem : tLista1)
            {
                System.out.println(tItem);
            }
        }
        else
            System.out.println(tDto4.getMensagem());
	}
	
	//TODO
	public static void ListaCompra() throws ParseException, JsonParseException, JsonMappingException, IOException
	{
		// Objeto para conversao JSON <---> Java
        ObjectMapper tConversorJsonJava = new ObjectMapper();

        // Matrícula salva para uso no teste
        int tId = 0;

        /*   Teste de Inclusão de aluno */

        // Criando o aluno para teste
        ListaCompra tListaCompra1 = new ListaCompra();
        tListaCompra1.setDataLista(sFormatador.parse("25/09/1998"));

        // Convertendo o objeto para JSON
        String tListaCompraJson = tConversorJsonJava.writeValueAsString(tListaCompra1);
        System.out.println("ListaCompra convertido em JSON");
        System.out.println(tListaCompraJson);

        // Chamando e Web Service de cadastramento
        System.out.println();
        String tResultado1 = JsonUtil.enviarPost(sUrlAplicacaoWS + "/ListaCompra/Cadastrar", tListaCompraJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado1);

        System.out.println("Resposta Convertida");
        ListaCompraDTO tDto1 = tConversorJsonJava.readValue(tResultado1, ListaCompraDTO.class);
        if (tDto1.isOk())
        {
            // Recuperando o aluno retornado e salvando a matrícula gerada
            ListaCompra tListaCompraRet = tDto1.getListaCompra();
            tId = tListaCompraRet.getIdListaCompra();

            System.out.println("ListaCompra Criado");
            System.out.println("Matrícula gerada : " + tId);
            System.out.println(tListaCompra1);
        }
        else
            System.out.println(tDto1.getMensagem());

        /*   Teste de Recuperação de aluno */

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado2 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/ListaCompra/Recuperar/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado2);

        System.out.println("Resposta Convertida");
        ListaCompraDTO tDto2 = tConversorJsonJava.readValue(tResultado2, ListaCompraDTO.class);
        if (tDto2.isOk())
        {
            // Recuperando o aluno retornado
            ListaCompra tListaCompraRet = tDto2.getListaCompra();

            System.out.println("ListaCompra Recuperado");
            System.out.println(tListaCompraRet);
        }
        else
            System.out.println(tDto2.getMensagem());

        /*   Teste de Alteração de aluno */

        // Atualizando o aluno
        System.out.println();
        tListaCompra1.setIdListaCompra(tId);
        tListaCompra1.setDataLista(sFormatador.parse("25/09/1998"));

        // Convertendo o objeto para JSON
        tListaCompraJson = tConversorJsonJava.writeValueAsString(tListaCompra1);
        System.out.println("ListaCompra convertido em JSON");
        System.out.println(tListaCompraJson);

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado3 = JsonUtil.enviarPut(sUrlAplicacaoWS + "/ListaCompra/Atualizar", tListaCompraJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado3);

        System.out.println("Resposta Convertida");
        ListaCompraDTO tDto3 = tConversorJsonJava.readValue(tResultado3, ListaCompraDTO.class);
        if (tDto3.isOk())
        {
            // Recuperando o aluno retornado
            ListaCompra tListaCompraRet = tDto3.getListaCompra();

            System.out.println("ListaCompra Atualizado");
            System.out.println(tListaCompraRet);
        }
        else
            System.out.println(tDto3.getMensagem());

        /*   Teste de Remoção de aluno */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado4 = JsonUtil.enviarDelete(sUrlAplicacaoWS + "/ListaCompra/Remover/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado4);

        System.out.println("Resposta Convertida");
        ListaCompraDTO tDto4 = tConversorJsonJava.readValue(tResultado4, ListaCompraDTO.class);
        if (tDto4.isOk())
        {
            System.out.println("ListaCompra Removido");
            System.out.println(tListaCompra1);
        }
        else
            System.out.println(tDto4.getMensagem());

        /*   Teste da Pesquisa Geral de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado5 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/ListaCompra/Pesquisar");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado5);

        System.out.println("Resposta Convertida");
        ListaCompraDTO tDto5 = tConversorJsonJava.readValue(tResultado5, ListaCompraDTO.class);
        if (tDto5.isOk())
        {
            // Recuperando a lista de alunos
            List<ListaCompra> tLista1 = tDto5.getLista();

            System.out.println("ListaCompras cadastrados no sistema");
            for (ListaCompra tListaCompra : tLista1)
            {
                System.out.println(tListaCompra);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por nome de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado6 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/ListaCompra/PesquisarPorNome/silva");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado6);

        System.out.println("Resposta Convertida");
        ListaCompraDTO tDto6 = tConversorJsonJava.readValue(tResultado6, ListaCompraDTO.class);
        if (tDto6.isOk())
        {
            // Recuperando a lista de alunos
            List<ListaCompra> tLista1 = tDto6.getLista();

            System.out.println("ListaCompras cadastrados no sistema como nome 'silva'");
            for (ListaCompra tListaCompra : tLista1)
            {
                System.out.println(tListaCompra);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por email de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado7 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/ListaCompra/PesquisarPorEmail/@outlook");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado7);

        System.out.println("Resposta Convertida");
        ListaCompraDTO tDto7 = tConversorJsonJava.readValue(tResultado7, ListaCompraDTO.class);
        if (tDto7.isOk())
        {
            // Recuperando a lista de alunos
            List<ListaCompra> tLista1 = tDto7.getLista();

            System.out.println("ListaCompras cadastrados no sistema com email '@outlook'");
            for (ListaCompra tListaCompra : tLista1)
            {
                System.out.println(tListaCompra);
            }
        }
        else
            System.out.println(tDto4.getMensagem());
	}
	
	//TODO
	public static void Loja() throws ParseException, JsonParseException, JsonMappingException, IOException
	{
		// Objeto para conversao JSON <---> Java
        ObjectMapper tConversorJsonJava = new ObjectMapper();

        // Matrícula salva para uso no teste
        int tId = 0;

        /*   Teste de Inclusão de aluno */

        // Criando o aluno para teste
        Loja tLoja1 = new Loja();
        tLoja1.setNome("Loja ");
        tLoja1.setLogomarca("3xc2vf4xs6d54fcf12sx4cv1sasdvgag");
        tLoja1.setSite("lojaTeste@test.com");

        // Convertendo o objeto para JSON
        String tLojaJson = tConversorJsonJava.writeValueAsString(tLoja1);
        System.out.println("Loja convertido em JSON");
        System.out.println(tLojaJson);

        // Chamando e Web Service de cadastramento
        System.out.println();
        String tResultado1 = JsonUtil.enviarPost(sUrlAplicacaoWS + "/Loja/Cadastrar", tLojaJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado1);

        System.out.println("Resposta Convertida");
        LojaDTO tDto1 = tConversorJsonJava.readValue(tResultado1, LojaDTO.class);
        if (tDto1.isOk())
        {
            // Recuperando o aluno retornado e salvando a matrícula gerada
            Loja tLojaRet = tDto1.getLoja();
            tId = tLojaRet.getIdLoja();

            System.out.println("Loja Criado");
            System.out.println("Matrícula gerada : " + tId);
            System.out.println(tLoja1);
        }
        else
            System.out.println(tDto1.getMensagem());

        /*   Teste de Recuperação de aluno */

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado2 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Loja/Recuperar/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado2);

        System.out.println("Resposta Convertida");
        LojaDTO tDto2 = tConversorJsonJava.readValue(tResultado2, LojaDTO.class);
        if (tDto2.isOk())
        {
            // Recuperando o aluno retornado
            Loja tLojaRet = tDto2.getLoja();

            System.out.println("Loja Recuperado");
            System.out.println(tLojaRet);
        }
        else
            System.out.println(tDto2.getMensagem());

        /*   Teste de Alteração de aluno */

        // Atualizando o aluno
        System.out.println();
        tLoja1.setIdLoja(tId);
        tLoja1.setNome("Loja ");
        tLoja1.setLogomarca("3xc2vf4xs6d54fcf12sx4cv1sasdvgag");
        tLoja1.setSite("lojaTeste@test.com");

        // Convertendo o objeto para JSON
        tLojaJson = tConversorJsonJava.writeValueAsString(tLoja1);
        System.out.println("Loja convertido em JSON");
        System.out.println(tLojaJson);

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado3 = JsonUtil.enviarPut(sUrlAplicacaoWS + "/Loja/Atualizar", tLojaJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado3);

        System.out.println("Resposta Convertida");
        LojaDTO tDto3 = tConversorJsonJava.readValue(tResultado3, LojaDTO.class);
        if (tDto3.isOk())
        {
            // Recuperando o aluno retornado
            Loja tLojaRet = tDto3.getLoja();

            System.out.println("Loja Atualizado");
            System.out.println(tLojaRet);
        }
        else
            System.out.println(tDto3.getMensagem());

        /*   Teste de Remoção de aluno */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado4 = JsonUtil.enviarDelete(sUrlAplicacaoWS + "/Loja/Remover/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado4);

        System.out.println("Resposta Convertida");
        LojaDTO tDto4 = tConversorJsonJava.readValue(tResultado4, LojaDTO.class);
        if (tDto4.isOk())
        {
            System.out.println("Loja Removido");
            System.out.println(tLoja1);
        }
        else
            System.out.println(tDto4.getMensagem());

        /*   Teste da Pesquisa Geral de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado5 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Loja/Pesquisar");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado5);

        System.out.println("Resposta Convertida");
        LojaDTO tDto5 = tConversorJsonJava.readValue(tResultado5, LojaDTO.class);
        if (tDto5.isOk())
        {
            // Recuperando a lista de alunos
            List<Loja> tLista1 = tDto5.getLista();

            System.out.println("Lojas cadastrados no sistema");
            for (Loja tLoja : tLista1)
            {
                System.out.println(tLoja);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        
        
	}
	
	//TODO
	public static void Pessoa() throws ParseException, JsonParseException, JsonMappingException, IOException
	{
		// Objeto para conversao JSON <---> Java
        ObjectMapper tConversorJsonJava = new ObjectMapper();

        // Matrícula salva para uso no teste
        String tEmail = null;

        /*   Teste de Inclusão de aluno */

        // Criando o aluno para teste
        Pessoa tPessoa1 = new Pessoa();
        tPessoa1.setNome("Tremendelvo Fronquio Vildo Peresta");
        tPessoa1.setEmail("tremendao_vildo@test.com.br");
        tPessoa1.setTelefone("(11)1111-1111");
        tPessoa1.setDtNascimento(sFormatador.parse("13/04/1975"));
        tPessoa1.setPrivilegio("priv");

        // Convertendo o objeto para JSON
        String tPessoaJson = tConversorJsonJava.writeValueAsString(tPessoa1);
        System.out.println("Pessoa convertido em JSON");
        System.out.println(tPessoaJson);

        // Chamando e Web Service de cadastramento
        System.out.println();
        String tResultado1 = JsonUtil.enviarPost(sUrlAplicacaoWS + "/Pessoa/Cadastrar", tPessoaJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado1);

        System.out.println("Resposta Convertida");
        PessoaDTO tDto1 = tConversorJsonJava.readValue(tResultado1, PessoaDTO.class);
        if (tDto1.isOk())
        {
            // Recuperando o aluno retornado e salvando a matrícula gerada
            Pessoa tPessoaRet = tDto1.getPessoa();
            tEmail = tPessoaRet.getEmail();

            System.out.println("Pessoa Criado");
            System.out.println(tPessoa1);
        }
        else
            System.out.println(tDto1.getMensagem());

        /*   Teste de Recuperação de aluno */

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado2 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Pessoa/Recuperar/" + tEmail);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado2);

        System.out.println("Resposta Convertida");
        PessoaDTO tDto2 = tConversorJsonJava.readValue(tResultado2, PessoaDTO.class);
        if (tDto2.isOk())
        {
            // Recuperando o aluno retornado
            Pessoa tPessoaRet = tDto2.getPessoa();

            System.out.println("Pessoa Recuperado");
            System.out.println(tPessoaRet);
        }
        else
            System.out.println(tDto2.getMensagem());

        /*   Teste de Alteração de aluno */

        // Atualizando o aluno
        System.out.println();
        tPessoa1.setNome("Tremendelvo Fronquio Vildo Peresta");
        tPessoa1.setEmail("tremendao_vildo@test.com.br");
        tPessoa1.setTelefone("(11)1111-1111");
        tPessoa1.setDtNascimento(sFormatador.parse("25/09/1998"));
        tPessoa1.setPrivilegio("priv");

        // Convertendo o objeto para JSON
        tPessoaJson = tConversorJsonJava.writeValueAsString(tPessoa1);
        System.out.println("Pessoa convertido em JSON");
        System.out.println(tPessoaJson);

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado3 = JsonUtil.enviarPut(sUrlAplicacaoWS + "/Pessoa/Atualizar", tPessoaJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado3);

        System.out.println("Resposta Convertida");
        PessoaDTO tDto3 = tConversorJsonJava.readValue(tResultado3, PessoaDTO.class);
        if (tDto3.isOk())
        {
            // Recuperando o aluno retornado
            Pessoa tPessoaRet = tDto3.getPessoa();

            System.out.println("Pessoa Atualizado");
            System.out.println(tPessoaRet);
        }
        else
            System.out.println(tDto3.getMensagem());

        /*   Teste de Remoção de aluno */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado4 = JsonUtil.enviarDelete(sUrlAplicacaoWS + "/Pessoa/Remover/" + tEmail);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado4);

        System.out.println("Resposta Convertida");
        PessoaDTO tDto4 = tConversorJsonJava.readValue(tResultado4, PessoaDTO.class);
        if (tDto4.isOk())
        {
            System.out.println("Pessoa Removido");
            System.out.println(tPessoa1);
        }
        else
            System.out.println(tDto4.getMensagem());

        /*   Teste da Pesquisa Geral de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado5 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Pessoa/Pesquisar");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado5);

        System.out.println("Resposta Convertida");
        PessoaDTO tDto5 = tConversorJsonJava.readValue(tResultado5, PessoaDTO.class);
        if (tDto5.isOk())
        {
            // Recuperando a lista de alunos
            List<Pessoa> tLista1 = tDto5.getLista();

            System.out.println("Pessoas cadastrados no sistema");
            for (Pessoa tPessoa : tLista1)
            {
                System.out.println(tPessoa);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por nome de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado6 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Pessoa/PesquisarPorNome/silva");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado6);

        System.out.println("Resposta Convertida");
        PessoaDTO tDto6 = tConversorJsonJava.readValue(tResultado6, PessoaDTO.class);
        if (tDto6.isOk())
        {
            // Recuperando a lista de alunos
            List<Pessoa> tLista1 = tDto6.getLista();

            System.out.println("Pessoas cadastrados no sistema como nome 'silva'");
            for (Pessoa tPessoa : tLista1)
            {
                System.out.println(tPessoa);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por email de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado7 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Pessoa/PesquisarPorEmail/@outlook");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado7);

        System.out.println("Resposta Convertida");
        PessoaDTO tDto7 = tConversorJsonJava.readValue(tResultado7, PessoaDTO.class);
        if (tDto7.isOk())
        {
            // Recuperando a lista de alunos
            List<Pessoa> tLista1 = tDto7.getLista();

            System.out.println("Pessoas cadastrados no sistema com email '@test'");
            for (Pessoa tPessoa : tLista1)
            {
                System.out.println(tPessoa);
            }
        }
        else
            System.out.println(tDto4.getMensagem());
	}
	
	//TODO
	public static void Produto() throws ParseException, JsonParseException, JsonMappingException, IOException
	{
		// Objeto para conversao JSON <---> Java
        ObjectMapper tConversorJsonJava = new ObjectMapper();

        // Matrícula salva para uso no teste
        int tId = 0;

        /*   Teste de Inclusão de aluno */

        // Criando o aluno para teste
        Produto tProduto1 = new Produto();
        tProduto1.setDescricao("Apenas um teste de adicionar o produto");
        tProduto1.setFabricante("Tester");
        tProduto1.setImagem("sailsyhoqyhdl7t218563ehvgduygsd");

        // Convertendo o objeto para JSON
        String tProdutoJson = tConversorJsonJava.writeValueAsString(tProduto1);
        System.out.println("Produto convertido em JSON");
        System.out.println(tProdutoJson);

        // Chamando e Web Service de cadastramento
        System.out.println();
        String tResultado1 = JsonUtil.enviarPost(sUrlAplicacaoWS + "/Produto/Cadastrar", tProdutoJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado1);

        System.out.println("Resposta Convertida");
        ProdutoDTO tDto1 = tConversorJsonJava.readValue(tResultado1, ProdutoDTO.class);
        if (tDto1.isOk())
        {
            // Recuperando o aluno retornado e salvando a matrícula gerada
            Produto tProdutoRet = tDto1.getProduto();
            tId = tProdutoRet.getIdProduto();

            System.out.println("Produto Criado");
            System.out.println("Matrícula gerada : " + tId);
            System.out.println(tProduto1);
        }
        else
            System.out.println(tDto1.getMensagem());

        /*   Teste de Recuperação de aluno */

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado2 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Produto/Recuperar/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado2);

        System.out.println("Resposta Convertida");
        ProdutoDTO tDto2 = tConversorJsonJava.readValue(tResultado2, ProdutoDTO.class);
        if (tDto2.isOk())
        {
            // Recuperando o aluno retornado
            Produto tProdutoRet = tDto2.getProduto();

            System.out.println("Produto Recuperado");
            System.out.println(tProdutoRet);
        }
        else
            System.out.println(tDto2.getMensagem());

        /*   Teste de Alteração de aluno */

        // Atualizando o aluno
        System.out.println();
        tProduto1.setIdProduto(tId);
        tProduto1.setDescricao("Apenas um teste de atualizar o produto");
        tProduto1.setFabricante("Tester");
        tProduto1.setImagem("sailsyhoqyhdl7t218563ehvgduygsd");

        // Convertendo o objeto para JSON
        tProdutoJson = tConversorJsonJava.writeValueAsString(tProduto1);
        System.out.println("Produto convertido em JSON");
        System.out.println(tProdutoJson);

        // Chamando e Web Service de Recuperação
        System.out.println();
        String tResultado3 = JsonUtil.enviarPut(sUrlAplicacaoWS + "/Produto/Atualizar", tProdutoJson);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado3);

        System.out.println("Resposta Convertida");
        ProdutoDTO tDto3 = tConversorJsonJava.readValue(tResultado3, ProdutoDTO.class);
        if (tDto3.isOk())
        {
            // Recuperando o aluno retornado
            Produto tProdutoRet = tDto3.getProduto();

            System.out.println("Produto Atualizado");
            System.out.println(tProdutoRet);
        }
        else
            System.out.println(tDto3.getMensagem());

        /*   Teste de Remoção de aluno */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado4 = JsonUtil.enviarDelete(sUrlAplicacaoWS + "/Produto/Remover/" + tId);

        System.out.println("Resposta Recebida");
        System.out.println(tResultado4);

        System.out.println("Resposta Convertida");
        ProdutoDTO tDto4 = tConversorJsonJava.readValue(tResultado4, ProdutoDTO.class);
        if (tDto4.isOk())
        {
            System.out.println("Produto Removido");
            System.out.println(tProduto1);
        }
        else
            System.out.println(tDto4.getMensagem());

        /*   Teste da Pesquisa Geral de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado5 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Produto/Pesquisar");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado5);

        System.out.println("Resposta Convertida");
        ProdutoDTO tDto5 = tConversorJsonJava.readValue(tResultado5, ProdutoDTO.class);
        if (tDto5.isOk())
        {
            // Recuperando a lista de alunos
            List<Produto> tLista1 = tDto5.getLista();

            System.out.println("Produtos cadastrados no sistema");
            for (Produto tProduto : tLista1)
            {
                System.out.println(tProduto);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        /*   Teste da Pesquisa por nome de alunos */

        // Chamando e Web Service de Remoção
        System.out.println();
        String tResultado6 = JsonUtil.enviarGet(sUrlAplicacaoWS + "/Produto/PesquisarPorNome/silva");

        System.out.println("Resposta Recebida");
        System.out.println(tResultado6);

        System.out.println("Resposta Convertida");
        ProdutoDTO tDto6 = tConversorJsonJava.readValue(tResultado6, ProdutoDTO.class);
        if (tDto6.isOk())
        {
            // Recuperando a lista de alunos
            List<Produto> tLista1 = tDto6.getLista();

            System.out.println("Produtos cadastrados no sistema como nome 'silva'");
            for (Produto tProduto : tLista1)
            {
                System.out.println(tProduto);
            }
        }
        else
            System.out.println(tDto4.getMensagem());


        
	}
	

}
