/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.ProdutoDTO;
import ca.tds.op.interfac.IProduto;
import ca.tds.op.model.Produto;

/**
 * @author Thanatos
 *
 */
public class ProdutoController 
{

	// Método para criar
    public static ProdutoDTO cadastrar(Produto pProduto)
    {
        if (pProduto == null)
            return new ProdutoDTO(false, "Tentativa de inserir uma Produto nulo");

        // Chamando a camada de persistência
        IProduto tDao = DaoFactory.getProdutoHibernate();
        Produto tProduto = tDao.criar(pProduto);

        // Verificando se houve erro de criação
        if (tProduto == null)
            return new ProdutoDTO(false, "Problemas na gravação da Produto");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ProdutoDTO(true, "Produto gravado com sucesso", tProduto);
    }

    // Método para recuperar
    public static ProdutoDTO recuperar(int pIdListaCompra)
    {
        // Lendo o objeto
    	IProduto tDao = DaoFactory.getProdutoHibernate();
        Produto tProduto = tDao.recuperar(pIdListaCompra);

        // Verificando se houve erro de recuperação
        if (tProduto == null)
            return new ProdutoDTO(false, "Produto não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ProdutoDTO(true, "Produto lido com sucesso", tProduto);
    }

    // Método para atualizar
    public static ProdutoDTO atualizar(Produto pProduto)
    {
        if (pProduto == null)
            return new ProdutoDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persistência
        IProduto tDao = DaoFactory.getProdutoHibernate();
        Produto tProduto = tDao.atualizar(pProduto);

        // Verificando se houve erro de atualização
        if (tProduto == null)
            return new ProdutoDTO(false, "Produto não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ProdutoDTO(true, "Produto regravado com sucesso", tProduto);
    }

    // Método para deletar
    public static ProdutoDTO remover(int pIdListaCompra)
    {
        // Removendo e verificando se houve erro de remoção
    	IProduto tDao = DaoFactory.getProdutoHibernate();
        if (! tDao.deletar(pIdListaCompra))
            return new ProdutoDTO(false, "Produto não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ProdutoDTO(true, "Produto removido com sucesso");
    }

    // Método para pesquisar 
    public static ProdutoDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	IProduto tDao = DaoFactory.getProdutoHibernate();
        List<Produto> tLista = tDao.pesquisar();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new ProdutoDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new ProdutoDTO(true, "Lista de Categorias recuperada", tLista);
    }
    

}
