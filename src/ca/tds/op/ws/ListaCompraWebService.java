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

import ca.tds.op.controller.ListaCompraController;
import ca.tds.op.dto.ListaCompraDTO;
import ca.tds.op.model.ListaCompra;

/**
 * @author Thanatos
 *
 */
@Path("/ListaCompra")
public class ListaCompraWebService 
{
	@POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ListaCompraDTO cadastrar(ListaCompra pListaCompra)
    {
        return ListaCompraController.cadastrar(pListaCompra);
    }

    @GET
    @Path("/Recuperar/{idListaCompra}")
    @Produces(MediaType.APPLICATION_JSON)
    public ListaCompraDTO recuperar(@PathParam("idListaCompra") int pIdListaCompra)
    {
        return  ListaCompraController.recuperar(pIdListaCompra);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ListaCompraDTO atualizar(ListaCompra pListaCompra)
    {
        return ListaCompraController.atualizar(pListaCompra);
    }

    @DELETE
    @Path("/Remover/{idListaCompra}")
    @Produces(MediaType.APPLICATION_JSON)
    public ListaCompraDTO remover(@PathParam("idListaCompra") int pIdListaCompra)
    {
        return ListaCompraController.remover(pIdListaCompra);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public ListaCompraDTO pesquisar()
    {
        return ListaCompraController.pesquisar();
    }

}
