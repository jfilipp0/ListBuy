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
import ca.tds.op.interfac.IProduto;
import ca.tds.op.model.Produto;
import ca.tds.op.util.ExceptionUtil;

/**
 * @author Thanatos
 *
 */
public class ProdutoHibernateDAO implements IProduto
{
	// TODO CREATE
	@Override
	public Produto criar(Produto pProduto) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pProduto);
            tSessao.flush();

            // Retornando o objeto lido
            return pProduto;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação de Produto");
		}
		return null;
	}

	// TODO RECOVERY
	@Override
	public Produto recuperar(Integer pIdProduto) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Produto tProduto = (Produto) tSessao.get(Produto.class, pIdProduto);

            // Retornando o objeto lido
            return tProduto;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperar de Produto");
		}
		return null;
	}

	// TODO UPDATE
	@Override
	public Produto atualizar(Produto pProduto) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pProduto);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pProduto;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização de Produto");
		}
		return null;
	}

	// TODO DELETE
	@Override
	public boolean deletar(Integer pIdProduto) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Removendo o objeto via hibernate
            tSessao.delete(tSessao.get(Produto.class, pIdProduto));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deletar Produto");
		}
		return false;
	}

	// TODO SEARCH
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> pesquisar() {
		// Criando a tLista de Pais vazia
        List<Produto> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM PRODUTO");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de pesquisa de Produto");
        }

        // Retornando a lista de Pais
        return tLista;
	}

}
