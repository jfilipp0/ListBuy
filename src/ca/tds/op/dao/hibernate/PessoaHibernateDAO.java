/**
 * 
 */
package ca.tds.op.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ca.tds.op.hibernate.HibernateUtil;
import ca.tds.op.interfac.IPessoa;
import ca.tds.op.model.Pessoa;
import ca.tds.op.util.ExceptionUtil;

/**
 * @author Thanatos
 *
 */
public class PessoaHibernateDAO implements IPessoa
{

	//TODO CREATE
	@Override
	public Pessoa criar(Pessoa pPessoa) 
	{
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();
            
            // salvando o objeto via hibernate
            tSessao.save(pPessoa);
            tSessao.flush();
            
            return pPessoa;
			
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação de pessoa!");
			
		}
		return null;
	}

	//TODO RECOVERY
	@Override
	public Pessoa recuperar(String pEmail) 
	{
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Pessoa tPessoa = (Pessoa) tSessao.get(Pessoa.class, pEmail);

            // Retornando o objeto lido
			return tPessoa;
			
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da pessoa");
			
		}
		return null;
	}

	//TODO UPDATE
	@Override
	public Pessoa atualizar(Pessoa pPessoa) 
	{
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pPessoa);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pPessoa;
			
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização da pessoa");
			
		}
		return null;
	}

	//TODO DELETE
	@Override
	public boolean deletar(String pEmail) 
	{
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Removendo o objeto via hibernate
            tSessao.delete(tSessao.get(Pessoa.class, pEmail));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
			
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deleção da pessoa");
			
		}
		return false;
	}

	//TODO SEARCH
	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> pesquisar() 
	{
		// Criando a tLista de alunos vazia
        List<Pessoa> tLista = new ArrayList<>();
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM PESSOA");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();
			
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de Pesquisa da lista de pessoa");
			
		}
		return tLista;
	}

	//TODO SEARCH BY EMAIL
	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> pesquisarEmail(String pEmail) 
	{
		// Acertando o critério de pesquisa
        String tEmailPesquisa = "%" + pEmail + "%";

        // Criando a tLista de alunos vazia
        List<Pessoa> tLista = new ArrayList<>();
		
		try 
		{
			// Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Pessoa.class)
                                          .add(Restrictions.like("email", tEmailPesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
			
			
		} catch (Exception tExcept) 
		{
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de pesquisa"
										+ " da lista de pessoa");
			
		}
		return tLista;
	}

	//TODO LOGIN
	@Override
	public Pessoa login(String pEmail, String pSenha) 
	{
		return null;
	}

	//TODO LOGOUT
	@Override
	public Pessoa logout() 
	{
		Pessoa tPessoa = new Pessoa();
		
		return tPessoa;
	}
	
	
	

}
