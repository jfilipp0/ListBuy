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

import ca.tds.op.controller.PessoaController;
import ca.tds.op.dto.PessoaDTO;
import ca.tds.op.model.Pessoa;

/**
 * @author Thanatos
 *
 */
public class PessoaWebService 
{
	@POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO cadastrar(Pessoa pPessoa)
    {
        return PessoaController.cadastrar(pPessoa);
    }

    @GET
    @Path("/Recuperar/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO recuperar(@PathParam("email") String pEmail)
    {
        return  PessoaController.recuperar(pEmail);
    }

    @PUT
    @Path("/Atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO atualizar(Pessoa pPessoa)
    {
        return PessoaController.atualizar(pPessoa);
    }

    @DELETE
    @Path("/Remover/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO remover(@PathParam("email") String pEmail)
    {
        return PessoaController.remover(pEmail);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO pesquisar()
    {
        return PessoaController.pesquisar();
    }
    
    @GET
    @Path("/PesquisarPorEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO pesquisarPorEmail(@PathParam("email") String pEmail)
    {
        return PessoaController.pesquisarPorEmail(pEmail);
    }
    
    @GET
    @Path("/Login/{email},{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO login(@PathParam("email") String pEmail,@PathParam("senha") String pSenha)
    {
        return PessoaController.login(pEmail, pSenha);
    }
    
    @GET
    @Path("/Logout")
    @Produces(MediaType.APPLICATION_JSON)
    public PessoaDTO logout()
    {
        return PessoaController.logout();
    }

}
