/**
 * 
 */
package ca.tds.op.interfac;

import java.util.List;

import ca.tds.op.model.ListaCompra;

/**
 * @author Thanatos
 *
 */
public interface IListaCompra 
{
	public ListaCompra criar(ListaCompra pListaCompra);
	public ListaCompra recuperar(Integer pIdListaCompra);
	public ListaCompra atualizar(ListaCompra pListaCompra);
	public boolean deletar(Integer pIdListaCompra);
	public List<ListaCompra> pesquisar();

}
