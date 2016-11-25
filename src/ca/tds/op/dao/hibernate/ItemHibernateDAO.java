/**
 * 
 */
package ca.tds.op.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ca.tds.op.hibernate.HibernateUtil;
import ca.tds.op.interfac.IItem;
import ca.tds.op.model.Item;
import ca.tds.op.util.ExceptionUtil;

/**
 * @author Thanatos
 *
 */
public class ItemHibernateDAO implements IItem {
	
	// TODO CREATE
	@Override
	public Item criar(Item pItem) 
	{
		try 
		{
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// salvando o objeto via hibernate
			tSessao.save(pItem);
			tSessao.flush();

			// retornando o objeto atualizado
			return pItem;
		} 
		catch (HibernateException tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Item");
		}
		return null;
	}

	
	
	// TODO RECOVERY
	@Override
	public Item recuperar(Integer pIdItem) 
	{
		try 
		{
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Recuperando o objeto via hibernate
			Item tItem = (Item) tSessao.get(Item.class, pIdItem);

			// Retornando o objeto lido
			return tItem;
		} 
		catch (HibernateException tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Item");
		}
		return null;
	}

	
	
	// TODO UPDATE
	@Override
	public Item atualizar(Item pItem) 
	{
		try 
		{
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Ataulizando o objeto via hibernate
			tSessao.merge(pItem);
			tSessao.flush();

			// Retornando o objeto atualizado
			return pItem;
		} 
		catch (HibernateException tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Item");
		}
		return null;
	}

	
	
	// TODO DELETE
	@Override
	public boolean deletar(Integer pIdItem) 
	{
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			tSessao.delete(tSessao.get(Item.class, pIdItem));
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} 
		catch (HibernateException tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Item");
		}
		return false;
	}

	
	
	// TODO SEARCH
	@Override
	@SuppressWarnings("unchecked")
	public List<Item> pesquisar() 
	{
		// Criando a tLista de Item vazia
		List<Item> tLista = new ArrayList<>();

		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o objeto para pesquisa
			Query tQuery = tSessao.createQuery("FROM CATEGORIA");

			// Recuperando a lista via hibernate
			tLista = tQuery.list();

		} 
		catch (HibernateException tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de pesquisa da lista de Item");
		}
		return tLista;
	}

	
	

}
