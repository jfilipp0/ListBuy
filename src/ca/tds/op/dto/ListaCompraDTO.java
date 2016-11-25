/**
 * 
 */
package ca.tds.op.dto;

import java.util.List;

import ca.tds.op.model.ListaCompra;

/**
 * @author Thanatos
 *
 */
public class ListaCompraDTO extends AbstractDTO<ListaCompra>
{
	/* Construtores da classe */
	public ListaCompraDTO()
	{
		super();
	}
	
	public ListaCompraDTO(boolean pOk,String pMensagem)
	{
		super(pOk, pMensagem);
	}
	
	public ListaCompraDTO(boolean pOk, String pMensagem, ListaCompra pListaCompra)
	{
		super(pOk, pMensagem, pListaCompra);
	}
	
	public ListaCompraDTO(boolean pOk, String pMensagem, List<ListaCompra> pList)
	{
		super(pOk, pMensagem, pList);
	}
	
	/* Métodos de acesso */
	public ListaCompra getListaCompra()
	{
		return getObjeto();
		
	}
	
	public void setListaCompra(ListaCompra pListaCompra)
	{
		setObjeto(pListaCompra);
		
	}

}
