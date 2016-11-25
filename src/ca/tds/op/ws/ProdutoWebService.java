/**
 * 
 */
package ca.tds.op.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.tds.op.controller.ProdutoController;
import ca.tds.op.dto.ProdutoDTO;
import ca.tds.op.model.Produto;

/**
 * @author Thanatos
 *
 */
@Path("/Produto")
public class ProdutoWebService 
{
	@POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO cadastrar(Produto pProduto)
    {
        return ProdutoController.cadastrar(pProduto);
    }

    @GET
    @Path("/Recuperar/{idProduto}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO recuperar(@PathParam("idProduto") int pIdProduto)
    {
        return  ProdutoController.recuperar(pIdProduto);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO atualizar(Produto pProduto)
    {
        return ProdutoController.atualizar(pProduto);
    }

    @DELETE
    @Path("/Remover/{idProduto}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO remover(@PathParam("idProduto") int pIdProduto)
    {
        return ProdutoController.remover(pIdProduto);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDTO pesquisar()
    {
        return ProdutoController.pesquisar();
    }

}
