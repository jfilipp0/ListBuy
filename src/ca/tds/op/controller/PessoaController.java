/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.PessoaDTO;
import ca.tds.op.interfac.IPessoa;
import ca.tds.op.model.Pessoa;

/**
 * @author Thanatos
 *
 */
public class PessoaController 
{
	// Método para criar um Pessoa
    public static PessoaDTO cadastrar(Pessoa pPessoa)
    {
        if (pPessoa == null)
            return new PessoaDTO(false, "Tentativa de inserir nulo");

        // Chamando a camada de persistência
        IPessoa tDao = DaoFactory.getPessoaHibernate();
        Pessoa tPessoa = tDao.criar(pPessoa);

        // Verificando se houve erro de criação
        if (tPessoa == null)
            return new PessoaDTO(false, "Problemas na gravação do Pessoa");

        // Retornando o indicativo de sucesso com o objeto criado
        return new PessoaDTO(true, "Pessoa gravado com sucesso", tPessoa);
    }

    // Método para recuperar um Pessoa
    public static PessoaDTO recuperar(String pEmail)
    {
        // Lendo o objeto
    	IPessoa tDao = DaoFactory.getPessoaHibernate();
        Pessoa tPessoa = tDao.recuperar(pEmail);

        // Verificando se houve erro de recuperação
        if (tPessoa == null)
            return new PessoaDTO(false, "Pessoa não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new PessoaDTO(true, "Pessoa lido com sucesso", tPessoa);
    }

    // Método para atualizar um Pessoa
    public static PessoaDTO atualizar(Pessoa pPessoa)
    {
        if (pPessoa == null)
            return new PessoaDTO(false, "Tentativa de atualizar uma Pessoa nulo");

        // Chamando a camada de persistência
        IPessoa tDao = DaoFactory.getPessoaHibernate();
        Pessoa tPessoa = tDao.atualizar(pPessoa);

        // Verificando se houve erro de atualização
        if (tPessoa == null)
            return new PessoaDTO(false, "Pessoa não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new PessoaDTO(true, "Pessoa regravado com sucesso", tPessoa);
    }

    // Método para deletar um Pessoa
    public static PessoaDTO remover(String pEmail)
    {
        // Removendo o Pessoa e verificando se houve erro de remoção
    	IPessoa tDao = DaoFactory.getPessoaHibernate();
        if (! tDao.deletar(pEmail))
            return new PessoaDTO(false, "Pessoa não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new PessoaDTO(true, "Pessoa removido com sucesso");
    }

    // Método para pesquisar todos os alunos
    public static PessoaDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	IPessoa tDao = DaoFactory.getPessoaHibernate();
        List<Pessoa> tLista = tDao.pesquisar();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new PessoaDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new PessoaDTO(true, "Lista recuperada", tLista);
    }

    // Método para pesquisar por email todos os alunos
    public static PessoaDTO pesquisarPorEmail(String pEmail)
    {
        // Caso o email de pesquisa seja nulo, retorna a lista geral
        if (pEmail == null)
            return pesquisar();

        // Obtendo a lista de alunos
        IPessoa tDao = DaoFactory.getPessoaHibernate();
        List<Pessoa> tLista = tDao.pesquisarEmail(pEmail);

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new PessoaDTO(false, "Nenhum registro encontrado com esse email '" + pEmail + "'");

        // Retornando a lista obtida
        return new PessoaDTO(true, "Lista recuperada", tLista);
    }
    
    public static PessoaDTO login(String pEmail,String pSenha)
    {
    	if(pEmail == null || pSenha == null )
    		return new PessoaDTO(false, "Tentativa de logar uma Pessoa nulo");
    	
    	// Lendo o objeto
    	IPessoa tDao = DaoFactory.getPessoaHibernate();
        Pessoa tPessoa = tDao.recuperar(pEmail);
        
        if(tPessoa==null)
        	return new PessoaDTO(false, "email não cadastrado ou digitado errado");
        
        if(tPessoa.getEmail() == pEmail && tPessoa.getSenha() == pSenha)
        	return new PessoaDTO(true, "Conectado com a "+tPessoa.getNome(),tPessoa);
        
    	
        return new PessoaDTO(false, "Tentativa de conectar não sucedida pois email/senha deve estar errada");
    }
    
    public static PessoaDTO logout()
    {
    	IPessoa tDao = DaoFactory.getPessoaHibernate();
    	Pessoa tPessoa = tDao.logout();
    	
    	if (tPessoa != null)
            return new PessoaDTO(false, "Pessoa não saiu ainda");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new PessoaDTO(true, "Pessoa conseguiu sair com sucesso");
    }

}
