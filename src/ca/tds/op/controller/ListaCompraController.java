/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.ListaCompraDTO;
import ca.tds.op.interfac.IListaCompra;
import ca.tds.op.model.ListaCompra;

/**
 * @author Thanatos
 *
 */
public class ListaCompraController 
{

	// Método para criar
    public static ListaCompraDTO cadastrar(ListaCompra pListaCompra)
    {
        if (pListaCompra == null)
            return new ListaCompraDTO(false, "Tentativa de inserir uma ListaCompra nulo");

        // Chamando a camada de persistência
        IListaCompra tDao = DaoFactory.getListaCompraHibernate();
        ListaCompra tListaCompra = tDao.criar(pListaCompra);

        // Verificando se houve erro de criação
        if (tListaCompra == null)
            return new ListaCompraDTO(false, "Problemas na gravação da ListaCompra");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ListaCompraDTO(true, "ListaCompra gravado com sucesso", tListaCompra);
    }

    // Método para recuperar
    public static ListaCompraDTO recuperar(int pIdListaCompra)
    {
        // Lendo o objeto
    	IListaCompra tDao = DaoFactory.getListaCompraHibernate();
        ListaCompra tListaCompra = tDao.recuperar(pIdListaCompra);

        // Verificando se houve erro de recuperação
        if (tListaCompra == null)
            return new ListaCompraDTO(false, "ListaCompra não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ListaCompraDTO(true, "ListaCompra lido com sucesso", tListaCompra);
    }

    // Método para atualizar
    public static ListaCompraDTO atualizar(ListaCompra pListaCompra)
    {
        if (pListaCompra == null)
            return new ListaCompraDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persistência
        IListaCompra tDao = DaoFactory.getListaCompraHibernate();
        ListaCompra tListaCompra = tDao.atualizar(pListaCompra);

        // Verificando se houve erro de atualização
        if (tListaCompra == null)
            return new ListaCompraDTO(false, "ListaCompra não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ListaCompraDTO(true, "ListaCompra regravado com sucesso", tListaCompra);
    }

    // Método para deletar
    public static ListaCompraDTO remover(int pIdListaCompra)
    {
        // Removendo e verificando se houve erro de remoção
    	IListaCompra tDao = DaoFactory.getListaCompraHibernate();
        if (! tDao.deletar(pIdListaCompra))
            return new ListaCompraDTO(false, "ListaCompra não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ListaCompraDTO(true, "ListaCompra removido com sucesso");
    }

    // Método para pesquisar 
    public static ListaCompraDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	IListaCompra tDao = DaoFactory.getListaCompraHibernate();
        List<ListaCompra> tLista = tDao.pesquisar();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new ListaCompraDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new ListaCompraDTO(true, "Lista de Categorias recuperada", tLista);
    }
    

}
