/**
 * 
 */
package ca.tds.op.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ca.tds.op.hibernate.HibernateUtil;
import ca.tds.op.interfac.ICategoria;
import ca.tds.op.model.Categoria;
import ca.tds.op.util.ExceptionUtil;

/**
 * @author Thanatos
 *
 */
public class CategoriaHibernateDAO implements ICategoria
{

	// TODO CREATE
	@Override
	public Categoria criar(Categoria pCategoria) {
	try
    {
		// Obtendo a sessão hibernate
        SessionFactory tFactory = HibernateUtil.getSessionFactory();
        Session tSessao = tFactory.getCurrentSession();

        // salvando o objeto via hibernate
        tSessao.save(pCategoria);
        tSessao.flush();

        // retornando o objeto atualizado
        return pCategoria;
    }
    catch (HibernateException tExcept)
    {
        ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Categoria");
    }
		return null;
	}

	
	// TODO RECOVERY
	@Override
	public Categoria recuperar(Integer pIdCategoria) {
		try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Categoria tCategoria = (Categoria) tSessao.get(Categoria.class, pIdCategoria);

            // Retornando o objeto lido
            return tCategoria;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Categoria");
        }
		return null;
	}

	// TODO UPDATE
	@Override
	public Categoria atualizar(Categoria pCategoria) {
		try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pCategoria);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pCategoria;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Categoria");
        }
		return null;
	}

	// TODO DELETE
	@Override
	public boolean deletar(Integer pIdCategoria) {
		try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Removendo o objeto via hibernate
            tSessao.delete(tSessao.get(Categoria.class, pIdCategoria));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Categoria");
        }
		return false;
	}

	// TODO SEARCH
	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> pesquisar() {
		 // Criando a tLista de Categoria vazia
        List<Categoria> tLista = new ArrayList<>();

        try
        {
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
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de pesquisa da lista de Categoria");
        }
		return tLista;
	}

	// TODO SEARCH BY NAME
	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> pesquisarNome(String pNome) {
		// Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de Categoria vazia
        List<Categoria> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Categoria.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de Pesquisa da lista de Categoria");
        }

		return tLista;
	}


	

}
