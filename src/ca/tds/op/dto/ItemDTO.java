/**
 * 
 */
package ca.tds.op.dto;

import java.util.List;

import ca.tds.op.model.Item;

/**
 * @author Thanatos
 *
 */
public class ItemDTO extends AbstractDTO<Item>
{
	/* Construtores da classe */
	public ItemDTO()
	{
		super();
	}
	
	public ItemDTO(boolean pOk,String pMensagem)
	{
		super(pOk, pMensagem);
	}
	
	public ItemDTO(boolean pOk, String pMensagem, Item pItem)
	{
		super(pOk, pMensagem, pItem);
	}
	
	public ItemDTO(boolean pOk, String pMensagem, List<Item> pList)
	{
		super(pOk, pMensagem, pList);
	}
	
	/* Métodos de acesso */
	public Item getItem()
	{
		return getObjeto();
		
	}
	
	public void setCidade(Item pItem)
	{
		setObjeto(pItem);
		
	}

}
