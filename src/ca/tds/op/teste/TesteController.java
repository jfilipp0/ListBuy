/**
 * 
 */
package ca.tds.op.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import ca.tds.op.controller.CategoriaController;
import ca.tds.op.controller.ItemController;
import ca.tds.op.controller.ListaCompraController;
import ca.tds.op.controller.LojaController;
import ca.tds.op.controller.PessoaController;
import ca.tds.op.controller.ProdutoController;
import ca.tds.op.dto.CategoriaDTO;
import ca.tds.op.dto.ItemDTO;
import ca.tds.op.dto.ListaCompraDTO;
import ca.tds.op.dto.LojaDTO;
import ca.tds.op.dto.PessoaDTO;
import ca.tds.op.dto.ProdutoDTO;
import ca.tds.op.hibernate.HibernateUtil;
import ca.tds.op.model.Categoria;
import ca.tds.op.model.Item;
import ca.tds.op.model.ListaCompra;
import ca.tds.op.model.Loja;
import ca.tds.op.model.Pessoa;
import ca.tds.op.model.Produto;

/**
 * @author Thanatos
 *
 */
public class TesteController 
{
	private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) 
	{
		// TODO TESTE UM E COMENTE O OUTRO TODO
		
		/**		Categoria Controller */
		//Categoria();
		
		/**		Item Controller */
		//Item();
		
		/**		ListaCompra Controller */
		ListaCompra();
		
		/**		Loja Controller */
		//Loja();
		
		/**		Pessoa Controller */
		//Pessoa();
		
		/**		Produto Controller */
		//Produto();
		
	}
	
	
	
	
	//METODOS
	//TODO CATEGORIA
	public static void Categoria()
	{
		try {
    		HibernateUtil.iniciarTransacao();
    		// Matrícula salva para uso no teste
            int tId = 0;

            // Criando o aluno para teste
            Categoria tCategoria1 = new Categoria();
            tCategoria1.setNome("ControllerCategoria");

            // Criando o aluno
            System.out.println();
            CategoriaDTO tDto1 = CategoriaController.cadastrar(tCategoria1);
            System.out.println("Criando a Categoria");
            if (tDto1.isOk())
            {
                // Recuperando o aluno retornado e salvando a matrícula gerada
                Categoria tCategoriaRet = tDto1.getCategoria();
                tId = tCategoriaRet.getIdCategoria();

                System.out.println("Categoria Criado");
                System.out.println("ID gerada : " + tId);
                System.out.println(tCategoria1);
            }
            else
                System.out.println(tDto1.getMensagem());

            // Recuperando o aluno
            System.out.println();
            CategoriaDTO tDto2 = CategoriaController.recuperar(tId);
            if (tDto2.isOk())
            {
                // Recuperando o aluno retornado
                Categoria tCategoriaRet = tDto2.getCategoria();

                System.out.println("Categoria Recuperado");
                System.out.println(tCategoriaRet);
            }
            else
                System.out.println(tDto2.getMensagem());

            // Atualizando o aluno
            System.out.println();
            tCategoria1.setIdCategoria(tId);
            tCategoria1.setNome("atualizando ControllerCategoria");
            CategoriaDTO tDto3 = CategoriaController.atualizar(tCategoria1);
            if (tDto3.isOk())
            {
                // Recuperando o aluno retornado
                Categoria tCategoriaRet = tDto3.getCategoria();

                System.out.println("Categoria Atualizado");
                System.out.println(tCategoriaRet);
            }
            else
                System.out.println(tDto3.getMensagem());

            // Removendo o aluno
            System.out.println();
            tCategoria1.setIdCategoria(tId);
            CategoriaDTO tDto4 = CategoriaController.remover(tId);
            if (tDto4.isOk())
            {
                System.out.println("Categoria Removida");
                System.out.println(tCategoria1);
            }
            else
                System.out.println(tDto4.getMensagem());

            // Recuperando a lista geral de alunos
            System.out.println();
            CategoriaDTO tDto5 = CategoriaController.pesquisar();
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

            // Recuperando a lista de alunos pesquisados por nome
            System.out.println();
            CategoriaDTO tDto6 = CategoriaController.pesquisarPorNome("a");
            if (tDto6.isOk())
            {
                // Recuperando a lista de alunos
                List<Categoria> tLista1 = tDto6.getLista();

                System.out.println("Categorias cadastrados no sistema como nome 'a' ");
                for (Categoria tCategoria : tLista1)
                {
                    System.out.println(tCategoria);
                }
            }
            else
                System.out.println(tDto4.getMensagem());
        	HibernateUtil.confirmarTransacao();
			
		} catch (Exception tExcept) {
			HibernateUtil.cancelarTransacao();
	    	
	    	HibernateUtil.fecharConexao();
		}
    	HibernateUtil.fecharConexao();

	}
	
	//TODO
	public static void Item()
	{
		try 
		{
			HibernateUtil.iniciarTransacao();
			// Matrícula salva para uso no teste
	        int tId = 0;

	        // Criando o aluno para teste
	        Item tItem1 = new Item();
	        tItem1.setDesconto(0.20);
	        tItem1.setPreco(32.5);
	        tItem1.setQuantidade(2);

	        // Criando o aluno
	        System.out.println();
	        ItemDTO tDto1 = ItemController.cadastrar(tItem1);
	        System.out.println("Criando o aluno");
	        if (tDto1.isOk())
	        {
	            // Recuperando o aluno retornado e salvando a matrícula gerada
	            Item tItemRet = tDto1.getItem();
	            tId = tItemRet.getIdItem();

	            System.out.println("Item Criado");
	            System.out.println("ID gerada : " + tId);
	            System.out.println(tItem1);
	        }
	        else
	            System.out.println(tDto1.getMensagem());

	        // Recuperando o aluno
	        System.out.println();
	        ItemDTO tDto2 = ItemController.recuperar(tId);
	        if (tDto2.isOk())
	        {
	            // Recuperando o aluno retornado
	            Item tItemRet = tDto2.getItem();

	            System.out.println("Item Recuperado");
	            System.out.println(tItemRet);
	        }
	        else
	            System.out.println(tDto2.getMensagem());

	        // Atualizando o aluno
	        System.out.println();
	        tItem1.setIdItem(tId);
	        tItem1.setDesconto(0.9);
	        tItem1.setPreco(32.5);
	        tItem1.setQuantidade(2);
	        ItemDTO tDto3 = ItemController.atualizar(tItem1);
	        if (tDto3.isOk())
	        {
	            // Recuperando o aluno retornado
	            Item tItemRet = tDto3.getItem();

	            System.out.println("Item Atualizado");
	            System.out.println(tItemRet);
	        }
	        else
	            System.out.println(tDto3.getMensagem());

	        // Removendo o aluno
	        System.out.println();
	        tItem1.setIdItem(tId);
	        ItemDTO tDto4 = ItemController.remover(tId);
	        if (tDto4.isOk())
	        {
	            System.out.println("Item Removido");
	            System.out.println(tItem1);
	        }
	        else
	            System.out.println(tDto4.getMensagem());

	        // Recuperando a lista geral de alunos
	        System.out.println();
	        ItemDTO tDto5 = ItemController.pesquisar();
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

	        
			HibernateUtil.confirmarTransacao();
		} 
		catch (Exception tExcept) 
		{
			HibernateUtil.cancelarTransacao();
	    	
	    	HibernateUtil.fecharConexao();
		}
		HibernateUtil.fecharConexao();
	}
	
	//TODO
	public static void ListaCompra()
	{
		try 
		{
			HibernateUtil.iniciarTransacao();
			
			int tId = 0;

	        // Criando o aluno para teste
	        ListaCompra tListaCompra1 = new ListaCompra();
	        tListaCompra1.setDataLista(sFormatador.parse("25/09/1998"));

	        // Criando o aluno
	        System.out.println();
	        ListaCompraDTO tDto1 = ListaCompraController.cadastrar(tListaCompra1);
	        System.out.println("Criando o aluno");
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

	        // Recuperando o aluno
	        System.out.println();
	        ListaCompraDTO tDto2 = ListaCompraController.recuperar(tId);
	        if (tDto2.isOk())
	        {
	            // Recuperando o aluno retornado
	            ListaCompra tListaCompraRet = tDto2.getListaCompra();

	            System.out.println("ListaCompra Recuperado");
	            System.out.println(tListaCompraRet);
	        }
	        else
	            System.out.println(tDto2.getMensagem());

	        // Atualizando o aluno
	        System.out.println();
	        tListaCompra1.setIdListaCompra(tId);
	        tListaCompra1.setDataLista(sFormatador.parse("25/09/1998"));
	        ListaCompraDTO tDto3 = ListaCompraController.atualizar(tListaCompra1);
	        if (tDto3.isOk())
	        {
	            // Recuperando o aluno retornado
	            ListaCompra tListaCompraRet = tDto3.getListaCompra();

	            System.out.println("ListaCompra Atualizado");
	            System.out.println(tListaCompraRet);
	        }
	        else
	            System.out.println(tDto3.getMensagem());

	        // Removendo o aluno
	        System.out.println();
	        tListaCompra1.setIdListaCompra(tId);
	        ListaCompraDTO tDto4 = ListaCompraController.remover(tId);
	        if (tDto4.isOk())
	        {
	            System.out.println("ListaCompra Removido");
	            System.out.println(tListaCompra1);
	        }
	        else
	            System.out.println(tDto4.getMensagem());

	        // Recuperando a lista geral de alunos
	        System.out.println();
	        ListaCompraDTO tDto5 = ListaCompraController.pesquisar();
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

	        
			
			HibernateUtil.confirmarTransacao();
		} 
		catch (Exception tExcept) 
		{
			HibernateUtil.cancelarTransacao();
	    	
	    	HibernateUtil.fecharConexao();
		}
		HibernateUtil.fecharConexao();
	}
	
	//TODO
	public static void Loja()
	{
		try 
		{
			HibernateUtil.iniciarTransacao();
			
			// Matrícula salva para uso no teste
	        int tId = 0;

	        // Criando o aluno para teste
	        Loja tLoja1 = new Loja();
	        tLoja1.setNome("Loja ");
	        tLoja1.setLogomarca("3xc2vf4xs6d54fcf12sx4cv1sasdvgag");
	        tLoja1.setSite("lojaTeste@test.com");

	        // Criando o aluno
	        System.out.println();
	        LojaDTO tDto1 = LojaController.cadastrar(tLoja1);
	        System.out.println("Criando o aluno");
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

	        // Recuperando o aluno
	        System.out.println();
	        LojaDTO tDto2 = LojaController.recuperar(tId);
	        if (tDto2.isOk())
	        {
	            // Recuperando o aluno retornado
	            Loja tLojaRet = tDto2.getLoja();

	            System.out.println("Loja Recuperado");
	            System.out.println(tLojaRet);
	        }
	        else
	            System.out.println(tDto2.getMensagem());

	        // Atualizando o aluno
	        System.out.println();
	        tLoja1.setIdLoja(tId);
	        tLoja1.setNome("Loja Teste");
	        tLoja1.setLogomarca("3xc2vf4xs6d54fcf12sx4cv1sasdvgag");
	        tLoja1.setSite("lojaTeste@test.com");
	        
	        
	        LojaDTO tDto3 = LojaController.atualizar(tLoja1);
	        if (tDto3.isOk())
	        {
	            // Recuperando o aluno retornado
	            Loja tLojaRet = tDto3.getLoja();

	            System.out.println("Loja Atualizado");
	            System.out.println(tLojaRet);
	        }
	        else
	            System.out.println(tDto3.getMensagem());

	        // Removendo a Loja
	        System.out.println();
	        tLoja1.setIdLoja(tId);
	        LojaDTO tDto4 = LojaController.remover(tId);
	        if (tDto4.isOk())
	        {
	            System.out.println("Loja Removido");
	            System.out.println(tLoja1);
	        }
	        else
	            System.out.println(tDto4.getMensagem());

	        // Recuperando a lista geral de alunos
	        System.out.println();
	        LojaDTO tDto5 = LojaController.pesquisar();
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

	        

			
			HibernateUtil.confirmarTransacao();
		} 
		catch (Exception tExcept) 
		{
			HibernateUtil.cancelarTransacao();
	    	
	    	HibernateUtil.fecharConexao();
		}
		HibernateUtil.fecharConexao();
	}
	
	//TODO 
	public static void Pessoa()
	{
		try 
		{
			HibernateUtil.iniciarTransacao();
			
			// Matrícula salva para uso no teste
	        String tEmail = null;

	        // Criando o aluno para teste
	        Pessoa tPessoa1 = new Pessoa();
	        tPessoa1.setNome("Tremendelvo Fronquio Vildo Peresta");
	        tPessoa1.setEmail("tremendao_vildo@test.com.br");
	        tPessoa1.setTelefone("(11)1111-1111");
	        tPessoa1.setDtNascimento(sFormatador.parse("25/09/1998"));
	        tPessoa1.setPrivilegio("priv");

	        // Criando o aluno
	        System.out.println();
	        PessoaDTO tDto1 = PessoaController.cadastrar(tPessoa1);
	        System.out.println("Criando o aluno");
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

	        // Recuperando o aluno
	        System.out.println();
	        PessoaDTO tDto2 = PessoaController.recuperar(tEmail);
	        if (tDto2.isOk())
	        {
	            // Recuperando o aluno retornado
	            Pessoa tPessoaRet = tDto2.getPessoa();

	            System.out.println("Pessoa Recuperado");
	            System.out.println(tPessoaRet);
	        }
	        else
	            System.out.println(tDto2.getMensagem());

	        // Atualizando o aluno
	        System.out.println();
	        tPessoa1.setEmail(tEmail);
	        tPessoa1.setNome("Tremendo Fronquio da Vista");
	        tPessoa1.setTelefone("(11)1111-1111");
	        tPessoa1.setDtNascimento(sFormatador.parse("25/09/1998"));
	        tPessoa1.setPrivilegio("priv");
	        
	        PessoaDTO tDto3 = PessoaController.atualizar(tPessoa1);
	        if (tDto3.isOk())
	        {
	            // Recuperando o aluno retornado
	            Pessoa tPessoaRet = tDto3.getPessoa();

	            System.out.println("Pessoa Atualizado");
	            System.out.println(tPessoaRet);
	        }
	        else
	            System.out.println(tDto3.getMensagem());

	        // Removendo o aluno
	        System.out.println();
	        tPessoa1.setEmail(tEmail);
	        PessoaDTO tDto4 = PessoaController.remover(tEmail);
	        if (tDto4.isOk())
	        {
	            System.out.println("Pessoa Removido");
	            System.out.println(tPessoa1);
	        }
	        else
	            System.out.println(tDto4.getMensagem());

	        // Recuperando a lista geral de alunos
	        System.out.println();
	        PessoaDTO tDto5 = PessoaController.pesquisar();
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

	        // Recuperando a lista de alunos pesquisados por email
	        System.out.println();
	        PessoaDTO tDto7 = PessoaController.pesquisarPorEmail(".br");
	        if (tDto7.isOk())
	        {
	            // Recuperando a lista de alunos
	            List<Pessoa> tLista1 = tDto7.getLista();

	            System.out.println("Pessoas cadastrados no sistema com email '.br'");
	            for (Pessoa tPessoa : tLista1)
	            {
	                System.out.println(tPessoa);
	            }
	        }
	        else
	            System.out.println(tDto4.getMensagem());
			
			HibernateUtil.confirmarTransacao();
		} 
		catch (Exception tExcept) 
		{
			HibernateUtil.cancelarTransacao();
	    	
	    	HibernateUtil.fecharConexao();
		}
		HibernateUtil.fecharConexao();
	}
	
	//TODO
	public static void Produto()
	{
		try 
		{
			HibernateUtil.iniciarTransacao();
			
			// Matrícula salva para uso no teste
	        int tId = 0;

	        // Criando o aluno para teste
	        Produto tProduto1 = new Produto();
	        tProduto1.setDescricao("Apenas um teste de adicionar o produto");
	        tProduto1.setFabricante("Tester");
	        tProduto1.setImagem("sailsyhoqyhdl7t218563ehvgduygsd");

	        // Criando o aluno
	        System.out.println();
	        ProdutoDTO tDto1 = ProdutoController.cadastrar(tProduto1);
	        System.out.println("Criando o aluno");
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

	        // Recuperando o aluno
	        System.out.println();
	        ProdutoDTO tDto2 = ProdutoController.recuperar(tId);
	        if (tDto2.isOk())
	        {
	            // Recuperando o aluno retornado
	            Produto tProdutoRet = tDto2.getProduto();

	            System.out.println("Produto Recuperado");
	            System.out.println(tProdutoRet);
	        }
	        else
	            System.out.println(tDto2.getMensagem());

	        // Atualizando o aluno
	        System.out.println();
	        tProduto1.setIdProduto(tId);
	        tProduto1.setDescricao("Apenas um teste de atualizar o produto");
	        tProduto1.setFabricante("Tester");
	        tProduto1.setImagem("sailsyhoqyhdl7t218563ehvgduygsd");
	        
	        
	        ProdutoDTO tDto3 = ProdutoController.atualizar(tProduto1);
	        if (tDto3.isOk())
	        {
	            // Recuperando o aluno retornado
	            Produto tProdutoRet = tDto3.getProduto();

	            System.out.println("Produto Atualizado");
	            System.out.println(tProdutoRet);
	        }
	        else
	            System.out.println(tDto3.getMensagem());

	        // Removendo o aluno
	        System.out.println();
	        tProduto1.setIdProduto(tId);
	        ProdutoDTO tDto4 = ProdutoController.remover(tId);
	        if (tDto4.isOk())
	        {
	            System.out.println("Produto Removido");
	            System.out.println(tProduto1);
	        }
	        else
	            System.out.println(tDto4.getMensagem());

	        // Recuperando a lista geral de alunos
	        System.out.println();
	        ProdutoDTO tDto5 = ProdutoController.pesquisar();
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

	        

	        
			
			HibernateUtil.confirmarTransacao();
		} 
		catch (Exception tExcept) 
		{
			HibernateUtil.cancelarTransacao();
	    	
	    	HibernateUtil.fecharConexao();
		}
		HibernateUtil.fecharConexao();
	}

}
