/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.ItemDTO;
import ca.tds.op.interfac.IItem;
import ca.tds.op.model.Item;

/**
 * @author Thanatos
 *
 */
public class ItemController 
{

	// Método para criar
    public static ItemDTO cadastrar(Item pItem)
    {
        if (pItem == null)
            return new ItemDTO(false, "Tentativa de inserir uma Item nulo");

        // Chamando a camada de persistência
        IItem tDao = DaoFactory.getItemHibernate();
        Item tItem = tDao.criar(pItem);

        // Verificando se houve erro de criação
        if (tItem == null)
            return new ItemDTO(false, "Problemas na gravação da Item");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ItemDTO(true, "Item gravado com sucesso", tItem);
    }

    // Método para recuperar
    public static ItemDTO recuperar(int pIdCategoria)
    {
        // Lendo o objeto
    	IItem tDao = DaoFactory.getItemHibernate();
        Item tItem = tDao.recuperar(pIdCategoria);

        // Verificando se houve erro de recuperação
        if (tItem == null)
            return new ItemDTO(false, "Item não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ItemDTO(true, "Item lido com sucesso", tItem);
    }

    // Método para atualizar
    public static ItemDTO atualizar(Item pItem)
    {
        if (pItem == null)
            return new ItemDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persistência
        IItem tDao = DaoFactory.getItemHibernate();
        Item tItem = tDao.atualizar(pItem);

        // Verificando se houve erro de atualização
        if (tItem == null)
            return new ItemDTO(false, "Item não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ItemDTO(true, "Item regravado com sucesso", tItem);
    }

    // Método para deletar
    public static ItemDTO remover(int pIdCategoria)
    {
        // Removendo e verificando se houve erro de remoção
    	IItem tDao = DaoFactory.getItemHibernate();
        if (! tDao.deletar(pIdCategoria))
            return new ItemDTO(false, "Item não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ItemDTO(true, "Item removido com sucesso");
    }

    // Método para pesquisar 
    public static ItemDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	IItem tDao = DaoFactory.getItemHibernate();
        List<Item> tLista = tDao.pesquisar();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new ItemDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new ItemDTO(true, "Lista de Categorias recuperada", tLista);
    }

}
