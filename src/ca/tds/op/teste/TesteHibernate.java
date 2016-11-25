/**
 * 
 */
package ca.tds.op.teste;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
public class TesteHibernate {

	private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) 
	{
		/**
		 * TODO  TESTA UM E DEIXA O OUTROS COMENTADOS
		 * */
		/**		testando Categoria com produto ManyToMany				*/
		CategoriaProduto();
		
		/**		testando Produto Com Loja ManyToMany					*/
		//LojaProduto();
		
		/**		testando Pessoa com ListaCompra ManyToMany				*/
		//PessoaListaCompra();
		
		/**		testando Item com ListaCompra OneToMany ManyToOne		*/
		//ListaCompraItem();
		
		/**		testando Item com ProdutoLoja OneToMany ManyToOne		*/
		//ItemProdutoLoja();
		

	}
	
	
	//		METODOS 
	
	
	/**
	 * TODO
	 * metodo CategoriaProduto
	 * esse metodo apenas testa se está fazendo o CRUD
	 */
	public static void CategoriaProduto()
	{
		try
		{
			
		
		HibernateUtil.iniciarTransacao();
		
		
		Integer id;

        Produto tProduto1 = new Produto("produto1","descr","ibagem","fab");
        Produto tProduto2 = new Produto("produto2","descr","ibagem","fab");
        Produto tProduto3 = new Produto("produto3","descr","ibagem","fab");
        Produto tProduto4 = new Produto("produto4","descr","ibagem","fab");

        Categoria tCategoria1 = new Categoria("categoria1");
        Categoria tCategoria2 = new Categoria("categoria2");

        Set<Produto> tProdutos1 = new HashSet<>();
        tProdutos1.add(tProduto1);
        tProdutos1.add(tProduto4);

        Set<Produto> tProdutos2 = new HashSet<>();
        tProdutos2.add(tProduto1);
        tProdutos2.add(tProduto2);
        tProdutos2.add(tProduto3);

        tCategoria1.setProdutos(tProdutos1);
        tCategoria2.setProdutos(tProdutos2);

        SessionFactory tFabrica = HibernateUtil.getSessionFactory();
        Session tSessao = tFabrica.getCurrentSession();

        System.out.println("Salvando os Produtos");
             tSessao.save(tProduto1);
        tSessao.flush();   
        tSessao.save(tProduto2);
        tSessao.flush();     
        tSessao.save(tProduto3);
        tSessao.flush();     
        tSessao.save(tProduto4);
        tSessao.flush();
        
        System.out.println("Salvando as Categorias");
        tSessao.save(tCategoria1);
        tSessao.flush();      
        tSessao.save(tCategoria2);
        tSessao.flush();

        System.out.println("Atualizar a Categoria");
        id = tProduto1.getIdProduto();
        tProdutos1.remove(id);
        tSessao.flush();
        
        tSessao.merge(tCategoria1);
        tSessao.flush();

        System.out.println("Remover a Categoria");
        id = tCategoria1.getIdCategoria();
        tSessao.delete(id);
        tSessao.flush();

        HibernateUtil.confirmarTransacao();
		}
		catch (Exception e) 
		{
			HibernateUtil.cancelarTransacao();
		}
		
        HibernateUtil.fecharConexao();
	}
	
	
	
	/**
	 * TODO
	 * metodo LojaProduto
	 * esse metodo apenas testa se está fazendo o CRUD
	 */
	public static void LojaProduto()
	{
		HibernateUtil.iniciarTransacao();
		try
		{
			Integer id;

	        Produto tProduto1 = new Produto("produto1","descr","3sd2f1sd32f1","fab");
	        Produto tProduto2 = new Produto("produto2","descr","dsf45d6f32sd1f8d","fab");
	        Produto tProduto3 = new Produto("produto3","descr","d4fd32c1v35d4f","fab");
	        Produto tProduto4 = new Produto("produto4","descr","yg5h4g23h18njm5","fab");
	
	        Loja tLoja1 = new Loja("Loja1","www.lojaum.com","hjasdgasmn");
	        Loja tLoja2 = new Loja("Loja2", "www.lojadois.com","gsdbjsgdcg");
	
	        Set<Produto> tProdutos1 = new HashSet<>();
	        tProdutos1.add(tProduto1);
	        tProdutos1.add(tProduto4);
	
	        Set<Produto> tProdutos2 = new HashSet<>();
	        tProdutos2.add(tProduto1);
	        tProdutos2.add(tProduto2);
	        tProdutos2.add(tProduto3);
	
	        tLoja1.setProdutos(tProdutos1);
	        tLoja2.setProdutos(tProdutos2);
	
	        SessionFactory tFabrica = HibernateUtil.getSessionFactory();
	        Session tSessao = tFabrica.getCurrentSession();
	
	        System.out.println("Salvando os Produtos");
	        tSessao.save(tProduto1);
	        tSessao.flush();
	        tSessao.save(tProduto2);
	        tSessao.flush();
	        tSessao.save(tProduto3);
	        tSessao.flush();
	        tSessao.save(tProduto4);
	        tSessao.flush();
	
	        System.out.println("Salvando as Lojas");
	        tSessao.save(tLoja1);
	        tSessao.flush();
	        tSessao.save(tLoja2);
	        tSessao.flush();
	
	        System.out.println("Atualizar a Produtos");
	        tProdutos1.remove(tProduto1);
	        tSessao.flush();

	        tSessao.merge(tLoja1);
	        tSessao.flush();
	
	        System.out.println("Remover a Loja");
	        id = tLoja2.getIdLoja();
	        tSessao.delete(id);
	        tSessao.flush();
	
	        HibernateUtil.confirmarTransacao();
		}
		catch (Exception e) 
		{
			HibernateUtil.cancelarTransacao();
		}
        HibernateUtil.fecharConexao();
        
	}
	
	
	/**
	 * TODO
	 * metodo PessoaListaCompra
	 * esse metodo apenas testa se está fazendo o CRUD
	 */
	public static void PessoaListaCompra()
	{
		HibernateUtil.iniciarTransacao();
		try
		{
			String email=null;

	        ListaCompra tListaCompra1 = new ListaCompra(sFormatador.parse("25/09/2016"));
	        ListaCompra tListaCompra2 = new ListaCompra(sFormatador.parse("26/09/2016"));
	        ListaCompra tListaCompra3 = new ListaCompra(sFormatador.parse("27/09/2016"));
	        ListaCompra tListaCompra4 = new ListaCompra(sFormatador.parse("28/09/2016"));
	
	        Pessoa tPessoa1 = new Pessoa("pessoa1@email.com","senha","nome1","1111111111",sFormatador.parse("27/05/1990"),"priv");
	        Pessoa tPessoa2 = new Pessoa("pessoa2@email.com","senha2","nome2","1111111111",sFormatador.parse("15/02/1980"),"priv");
	
	        Set<ListaCompra> tListasCompras1 = new HashSet<>();
	        tListasCompras1.add(tListaCompra1);
	        tListasCompras1.add(tListaCompra2);
	
	        Set<ListaCompra> tListasCompras2 = new HashSet<>();
	        tListasCompras2.add(tListaCompra1);
	        tListasCompras2.add(tListaCompra3);
	        tListasCompras2.add(tListaCompra4);
	
	        tPessoa1.setListasCompras(tListasCompras1);
	        tPessoa2.setListasCompras(tListasCompras2);
	
	        SessionFactory tFabrica = HibernateUtil.getSessionFactory();
	        Session tSessao = tFabrica.getCurrentSession();
	
	        System.out.println("Salvando os Produtos");
	        tSessao.save(tListaCompra1);
	        tSessao.flush();
	        tSessao.save(tListaCompra2);
	        tSessao.flush();
	        tSessao.save(tListaCompra3);
	        tSessao.flush();
	        tSessao.save(tListaCompra4);
	        tSessao.flush();
	
	        System.out.println("Salvando as Categorias");
	        tSessao.save(tPessoa1);
	        tSessao.flush();
	        tSessao.save(tPessoa2);
	        tSessao.flush();
	
	        System.out.println("Atualizar a Categoria");
	        tListasCompras1.remove(tListaCompra1);
	        tSessao.flush();

	        tSessao.merge(tPessoa1);
	        tSessao.flush();
	
	        System.out.println("Remover a Categoria");
	        email = tPessoa1.getEmail();
	        tSessao.delete(email);
	        tSessao.flush();
	
	        HibernateUtil.confirmarTransacao();
		}
		catch (Exception e) 
		{
			HibernateUtil.cancelarTransacao();
		}
        HibernateUtil.fecharConexao();
        

	}
	
	
	
	/**
	 * TODO
	 * metodo ItemListaCompra
	 * esse metodo apenas testa se está fazendo o CRUD
	 */
	public static void ListaCompraItem()
	{
		HibernateUtil.iniciarTransacao();
		try
		{
			Integer id;

			Item tItem1 = new Item(0.1, 12.9, 3);
	        Item tItem2 = new Item(0.1, 12.5, 3);
	        Item tItem3 = new Item(0.25, 55.00, 1);
	        Item tItem4 = new Item(1., 10.00, 2);
	
	        ListaCompra tListaCompra1 = new ListaCompra(sFormatador.parse("28/09/2016"));
	        ListaCompra tListaCompra2 = new ListaCompra(sFormatador.parse("28/09/2016"));
	
	        Set<Item> tItens1 = new HashSet<>();
	        tItens1.add(tItem1);
	        tItens1.add(tItem3);
	
	        Set<Item> tItens2 = new HashSet<>();
	        tItens2.add(tItem1);
	        tItens2.add(tItem2);
	        tItens2.add(tItem4);
	
	        tListaCompra1.setItens(tItens1);
	        tListaCompra2.setItens(tItens2);
	
	        SessionFactory tFabrica = HibernateUtil.getSessionFactory();
	        Session tSessao = tFabrica.getCurrentSession();
	
	        System.out.println("Salvando os Itens");
	        tSessao.save(tItem1);
	        tSessao.flush();
	        tSessao.save(tItem2);
	        tSessao.flush();
	        tSessao.save(tItem3);
	        tSessao.flush();
	        tSessao.save(tItem4);
	        tSessao.flush();
	
	        System.out.println("Salvando as ListaCompras");
	        tSessao.save(tListaCompra1);
	        tSessao.flush();
	        tSessao.save(tListaCompra2);
	        tSessao.flush();
	
	        System.out.println("Atualizar a Categoria");
	        tItens2.remove(tItem1);
	        tSessao.flush();

	        tSessao.merge(tListaCompra2);
	        tSessao.flush();
	
	        System.out.println("Remover a Categoria");
	        id = tListaCompra1.getIdListaCompra();
	        tSessao.delete(id);
	        tSessao.flush();
	
	        HibernateUtil.confirmarTransacao();
		}
		catch (Exception e) 
		{
			HibernateUtil.cancelarTransacao();
		}
        HibernateUtil.fecharConexao();
		
	}
	
	
	
	/**
	 * TODO
	 * metodo ItemProdutoLoja
	 * esse metodo apenas testa se está fazendo o CRUD
	 */
	public static void ItemProdutoLoja()
	{
		HibernateUtil.iniciarTransacao();
		try
		{
			Integer id;

	        Produto tProduto1 = new Produto("produto1","descr","3sd2f1sd32f1","fab");
	        Produto tProduto2 = new Produto("produto2","descr","dsf45d6f32sd1f8d","fab");
	        Produto tProduto3 = new Produto("produto3","descr","d4fd32c1v35d4f","fab");
	        Produto tProduto4 = new Produto("produto4","descr","yg5h4g23h18njm5","fab");
	
	        Loja tLoja1 = new Loja("Loja1","www.lojaum.com","hjasdgasmn");
	        Loja tLoja2 = new Loja("Loja2", "www.lojadois.com","gsdbjsgdcg");
	        
	        Item tItem1 = new Item(0.1, 12.9, 3);
	        Item tItem2 = new Item(0.1, 12.5, 3);
	        Item tItem3 = new Item(0.25, 55.00, 1);
	        Item tItem4 = new Item(0.0, 10.00, 2);
	        Item tItem5 = new Item(0.90, 8.50, 4);
	
	        //produtos
	        Set<Produto> tProdutos1 = new HashSet<>();
	        tProdutos1.add(tProduto1);
	        tProdutos1.add(tProduto4);
	
	        Set<Produto> tProdutos2 = new HashSet<>();
	        tProdutos2.add(tProduto1);
	        tProdutos2.add(tProduto2);
	        tProdutos2.add(tProduto3);
	        
	        //lojas
	        tLoja1.setProdutos(tProdutos1);
	        tLoja2.setProdutos(tProdutos2);
	        
	        //Itens
	        tItem1.setLojas(tLoja2);
	        tItem1.setProdutos(tProduto1);
	        
	        tItem2.setLojas(tLoja2);
	        tItem2.setProdutos(tProduto2);

	        tItem3.setLojas(tLoja2);
	        tItem3.setProdutos(tProduto3);

	        tItem4.setLojas(tLoja1);
	        tItem4.setProdutos(tProduto1);

	        tItem5.setLojas(tLoja1);
	        tItem5.setProdutos(tProduto4);
	
	        SessionFactory tFabrica = HibernateUtil.getSessionFactory();
	        Session tSessao = tFabrica.getCurrentSession();
	
	        System.out.println("Salvando os Produtos");
	        tSessao.save(tProduto1);
	        tSessao.flush();
	        tSessao.save(tProduto2);
	        tSessao.flush();
	        tSessao.save(tProduto3);
	        tSessao.flush();
	        tSessao.save(tProduto4);
	        tSessao.flush();
	
	        System.out.println("Salvando as Categorias");
	        tSessao.save(tLoja1);
	        tSessao.flush();
	        tSessao.save(tLoja2);
	        tSessao.flush();
	        
	        System.out.println("Salvando Itens");
	        tSessao.save(tItem1);
	        tSessao.flush();
	        tSessao.save(tItem2);
	        tSessao.flush();
	        tSessao.save(tItem3);
	        tSessao.flush();
	        tSessao.save(tItem4);
	        tSessao.flush();
	        tSessao.save(tItem5);
	        tSessao.flush();
	
	        System.out.println("Atualizar Produto");
	        tProdutos1.remove(tProduto1);
	        tSessao.flush();

	        tSessao.merge(tLoja1);
	        tSessao.flush();
	        
	        tSessao.merge(tItem1);
	        tSessao.merge(tItem4);
	
	        System.out.println("Remover a Categoria");
	        id = tItem5.getIdItem();
	        tSessao.delete(id);
	        tSessao.flush();
	
	        HibernateUtil.confirmarTransacao();
		}
		catch (Exception e) 
		{
			HibernateUtil.cancelarTransacao();
		}
        HibernateUtil.fecharConexao();
		
	}
	

}
