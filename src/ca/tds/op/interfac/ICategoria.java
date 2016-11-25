/**
 * 
 */
package ca.tds.op.interfac;

import java.util.List;

import ca.tds.op.model.Categoria;

/**
 * @author Thanatos
 *
 */
public interface ICategoria 
{
	public Categoria criar(Categoria pCategoria);
	public Categoria recuperar(Integer pIdCategoria);
	public Categoria atualizar(Categoria pCategoria);
	public boolean deletar(Integer pIdCategoria);
	public List<Categoria> pesquisar();
	public List<Categoria> pesquisarNome(String pNome);
	

}
