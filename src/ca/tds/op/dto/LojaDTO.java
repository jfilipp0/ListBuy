/**
 * 
 */
package ca.tds.op.dto;

import java.util.List;

import ca.tds.op.model.Loja;

/**
 * @author Thanatos
 *
 */
public class LojaDTO extends AbstractDTO<Loja>
{
	/* Construtores da classe */
	public LojaDTO()
	{
		super();
	}
	
	public LojaDTO(boolean pOk,String pMensagem)
	{
		super(pOk, pMensagem);
	}
	
	public LojaDTO(boolean pOk, String pMensagem, Loja pPais)
	{
		super(pOk, pMensagem, pPais);
	}
	
	public LojaDTO(boolean pOk, String pMensagem, List<Loja> pList)
	{
		super(pOk, pMensagem, pList);
	}
	
	/* Métodos de acesso */
	public Loja getLoja()
	{
		return getObjeto();
		
	}

}
