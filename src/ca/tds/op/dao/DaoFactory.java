/**
 * 
 */
package ca.tds.op.dao;

import ca.tds.op.dao.hibernate.CategoriaHibernateDAO;
import ca.tds.op.dao.hibernate.ItemHibernateDAO;
import ca.tds.op.dao.hibernate.ListaCompraHibernateDAO;
import ca.tds.op.dao.hibernate.LojaHibernateDAO;
import ca.tds.op.dao.hibernate.PessoaHibernateDAO;
import ca.tds.op.dao.hibernate.ProdutoHibernateDAO;

/**
 * @author Thanatos
 *
 */
public class DaoFactory 
{
	//apenas os get de todos os ClassHibernateDAO
	public static CategoriaHibernateDAO getCategoriaHibernate()
	{
		return new CategoriaHibernateDAO();
	}
	
	public static ItemHibernateDAO getItemHibernate()
	{
		return new ItemHibernateDAO();
	}
	
	public static ListaCompraHibernateDAO getListaCompraHibernate()
	{
		return new ListaCompraHibernateDAO();
	}
	
	public static LojaHibernateDAO getLojaHibernate()
	{
		return new LojaHibernateDAO();
	}
	
	public static PessoaHibernateDAO getPessoaHibernate()
	{
		return new PessoaHibernateDAO();
	}
	
	public static ProdutoHibernateDAO getProdutoHibernate()
	{
		return new ProdutoHibernateDAO();
	}
	
	

}
