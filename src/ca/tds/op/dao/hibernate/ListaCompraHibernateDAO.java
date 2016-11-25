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
import ca.tds.op.interfac.IListaCompra;
import ca.tds.op.model.ListaCompra;
import ca.tds.op.util.ExceptionUtil;

/**
 * @author Thanatos
 *
 */
public class ListaCompraHibernateDAO implements IListaCompra
{

	// TODO CREATE
	@Override
	public ListaCompra criar(ListaCompra pListaCompra) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pListaCompra);
            tSessao.flush();

            // Retornando o objeto lido
            return pListaCompra;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação de ListaCompra");
		}
		return null;
	}

	// TODO RECOVERY
	@Override
	public ListaCompra recuperar(Integer pIdListaCompra) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            ListaCompra tListaCompra = (ListaCompra) tSessao.get(ListaCompra.class, pIdListaCompra);

            // Retornando o objeto lido
            return tListaCompra;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperar de ListaCompra");
		}
		return null;
	}

	// TODO UPDATE
	@Override
	public ListaCompra atualizar(ListaCompra pListaCompra) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pListaCompra);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pListaCompra;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização de ListaCompra");
		}
		return null;
	}

	// TODO DELETE
	@Override
	public boolean deletar(Integer pIdListaCompra) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Removendo o objeto via hibernate
            tSessao.delete(tSessao.get(ListaCompra.class, pIdListaCompra));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deletar ListaCompra");
		}
		return false;
	}

	// TODO SEARCH
	@SuppressWarnings("unchecked")
	@Override
	public List<ListaCompra> pesquisar() {
		// Criando a tLista de ListaCompra vazia
        List<ListaCompra> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM LISTACOMPRA");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de pesquisa de ListaCompra");
        }

        // Retornando a lista de ListaCompra
        return tLista;
	}

}
