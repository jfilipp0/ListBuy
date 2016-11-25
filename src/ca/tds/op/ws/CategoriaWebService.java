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

import ca.tds.op.controller.CategoriaController;
import ca.tds.op.dto.CategoriaDTO;
import ca.tds.op.model.Categoria;

/**
 * @author Thanatos
 *
 */
@Path("/Categoria")
public class CategoriaWebService 
{
	@POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDTO cadastrar(Categoria pCategoria)
    {
        return CategoriaController.cadastrar(pCategoria);
    }

    @GET
    @Path("/Recuperar/{idCategoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDTO recuperar(@PathParam("idCategoria") int pIdCategoria)
    {
        return  CategoriaController.recuperar(pIdCategoria);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDTO atualizar(Categoria pCategoria)
    {
        return CategoriaController.atualizar(pCategoria);
    }

    @DELETE
    @Path("/Remover/{idCategoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDTO remover(@PathParam("idCategoria") int pIdCategoria)
    {
        return CategoriaController.remover(pIdCategoria);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDTO pesquisar()
    {
        return CategoriaController.pesquisar();
    }
    

}
