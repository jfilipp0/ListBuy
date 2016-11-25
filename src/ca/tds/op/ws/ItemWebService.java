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

import ca.tds.op.controller.ItemController;
import ca.tds.op.dto.ItemDTO;
import ca.tds.op.model.Item;

/**
 * @author Thanatos
 *
 */
@Path("/Item")
public class ItemWebService 
{
	@POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ItemDTO cadastrar(Item pItem)
    {
        return ItemController.cadastrar(pItem);
    }

    @GET
    @Path("/Recuperar/{idItem}")
    @Produces(MediaType.APPLICATION_JSON)
    public ItemDTO recuperar(@PathParam("idItem") int pIdItem)
    {
        return  ItemController.recuperar(pIdItem);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ItemDTO atualizar(Item pItem)
    {
        return ItemController.atualizar(pItem);
    }

    @DELETE
    @Path("/Remover/{idItem}")
    @Produces(MediaType.APPLICATION_JSON)
    public ItemDTO remover(@PathParam("idItem") int pIdItem)
    {
        return ItemController.remover(pIdItem);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public ItemDTO pesquisar()
    {
        return ItemController.pesquisar();
    }

}
