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

import ca.tds.op.controller.LojaController;
import ca.tds.op.dto.LojaDTO;
import ca.tds.op.model.Loja;

/**
 * @author Thanatos
 *
 */
@Path("/Loja")
public class LojaWebService 
{
	@POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LojaDTO cadastrar(Loja pLoja)
    {
        return LojaController.cadastrar(pLoja);
    }

    @GET
    @Path("/Recuperar/{idLoja}")
    @Produces(MediaType.APPLICATION_JSON)
    public LojaDTO recuperar(@PathParam("idLoja") int pIdLoja)
    {
        return  LojaController.recuperar(pIdLoja);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LojaDTO atualizar(Loja pLoja)
    {
        return LojaController.atualizar(pLoja);
    }

    @DELETE
    @Path("/Remover/{idLoja}")
    @Produces(MediaType.APPLICATION_JSON)
    public LojaDTO remover(@PathParam("idLoja") int pIdLoja)
    {
        return LojaController.remover(pIdLoja);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public LojaDTO pesquisar()
    {
        return LojaController.pesquisar();
    }

}
