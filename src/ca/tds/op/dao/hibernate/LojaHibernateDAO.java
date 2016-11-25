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
import ca.tds.op.interfac.ILoja;
import ca.tds.op.model.Loja;
import ca.tds.op.util.ExceptionUtil;

/**
 * @author Thanatos
 *
 */
public class LojaHibernateDAO implements ILoja
{
	// TODO CREATE
	@Override
	public Loja criar(Loja pLoja) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pLoja);
            tSessao.flush();

            // Retornando o objeto lido
            return pLoja;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação de Loja");
		}
		return null;
	}

	// TODO RECOVERY
	@Override
	public Loja recuperar(Integer pIdLoja) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Loja tLoja = (Loja) tSessao.get(Loja.class, pIdLoja);

            // Retornando o objeto lido
            return tLoja;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperar de País");
		}
		return null;
	}

	// TODO UPDATE
	@Override
	public Loja atualizar(Loja pLoja) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pLoja);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pLoja;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização de Loja");
		}
		return null;
	}

	// TODO DELETE
	@Override
	public boolean deletar(Integer pIdLoja) {
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Removendo o objeto via hibernate
            tSessao.delete(tSessao.get(Loja.class, pIdLoja));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deletar Loja");
		}
		return false;
	}

	// TODO SEARCH
	@SuppressWarnings("unchecked")
	@Override
	public List<Loja> pesquisar() {
		// Criando a tLista de Loja vazia
        List<Loja> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM LOJA");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de pesquisa de Loja");
        }

        // Retornando a lista de Loja
        return tLista;
	}

}
