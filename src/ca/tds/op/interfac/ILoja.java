/**
 * 
 */
package ca.tds.op.interfac;

import java.util.List;

import ca.tds.op.model.Loja;

/**
 * @author Thanatos
 *
 */
public interface ILoja 
{
	public Loja criar(Loja pLoja);
	public Loja recuperar(Integer pIdLoja);
	public Loja atualizar(Loja pLoja);
	public boolean deletar(Integer pIdLoja);
	public List<Loja> pesquisar();
	

}
