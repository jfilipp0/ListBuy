/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.LojaDTO;
import ca.tds.op.interfac.ILoja;
import ca.tds.op.model.Loja;

/**
 * @author Thanatos
 *
 */
public class LojaController 
{

	// Método para criar
    public static LojaDTO cadastrar(Loja pLoja)
    {
        if (pLoja == null)
            return new LojaDTO(false, "Tentativa de inserir uma Loja nulo");

        // Chamando a camada de persistência
        ILoja tDao = DaoFactory.getLojaHibernate();
        Loja tLoja = tDao.criar(pLoja);

        // Verificando se houve erro de criação
        if (tLoja == null)
            return new LojaDTO(false, "Problemas na gravação da Loja");

        // Retornando o indicativo de sucesso com o objeto criado
        return new LojaDTO(true, "Loja gravado com sucesso", tLoja);
    }

    // Método para recuperar
    public static LojaDTO recuperar(int pIdListaCompra)
    {
        // Lendo o objeto
    	ILoja tDao = DaoFactory.getLojaHibernate();
        Loja tLoja = tDao.recuperar(pIdListaCompra);

        // Verificando se houve erro de recuperação
        if (tLoja == null)
            return new LojaDTO(false, "Loja não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new LojaDTO(true, "Loja lido com sucesso", tLoja);
    }

    // Método para atualizar
    public static LojaDTO atualizar(Loja pLoja)
    {
        if (pLoja == null)
            return new LojaDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persistência
        ILoja tDao = DaoFactory.getLojaHibernate();
        Loja tLoja = tDao.atualizar(pLoja);

        // Verificando se houve erro de atualização
        if (tLoja == null)
            return new LojaDTO(false, "Loja não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new LojaDTO(true, "Loja regravado com sucesso", tLoja);
    }

    // Método para deletar
    public static LojaDTO remover(int pIdListaCompra)
    {
        // Removendo e verificando se houve erro de remoção
    	ILoja tDao = DaoFactory.getLojaHibernate();
        if (! tDao.deletar(pIdListaCompra))
            return new LojaDTO(false, "Loja não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new LojaDTO(true, "Loja removido com sucesso");
    }

    // Método para pesquisar 
    public static LojaDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	ILoja tDao = DaoFactory.getLojaHibernate();
        List<Loja> tLista = tDao.pesquisar();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new LojaDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new LojaDTO(true, "Lista de Categorias recuperada", tLista);
    }
    

}
