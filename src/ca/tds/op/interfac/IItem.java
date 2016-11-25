/**
 * 
 */
package ca.tds.op.interfac;

import java.util.List;

import ca.tds.op.model.Item;

/**
 * @author Thanatos
 *
 */
public interface IItem 
{
	public Item criar(Item pItem);
	public Item recuperar(Integer pIdItem);
	public Item atualizar(Item pItem);
	public boolean deletar(Integer pIdItem);
	public List<Item> pesquisar();
	//public List<Item> pesquisarNome(String pNome);

}
