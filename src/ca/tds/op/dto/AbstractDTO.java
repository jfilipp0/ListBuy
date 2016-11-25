/*
 * TDTO.java
 *
 * Classe que representa o retorno do serviço de manutenção de cidades.
 *
 * © 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Histórico
 * 14/07/2016 – Versão 1.0 - José Augusto – Criação do arquivo
 *
 */
package ca.tds.op.dto;

import java.util.List;

public abstract class AbstractDTO<T>
{
    /* Atributos normais */
    private boolean      ok;
    private String       mensagem;
    private T       objeto;
    private List<T> lista;

    /* Construtores da classe */
    public AbstractDTO()
    {
        super();
    }

    public AbstractDTO(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public AbstractDTO(boolean pOk, String pMensagem, T pObjeto)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        objeto = pObjeto;
    }

    public AbstractDTO(boolean pOk, String pMensagem, List<T> pLista)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        lista = pLista;
    }

    /* Métodos de acesso */
    public boolean isOk()
    {
        return ok;
    }

    public void setOk(boolean pOk)
    {
        ok = pOk;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String pMensagem)
    {
        mensagem = pMensagem;
    }

    protected T getObjeto()
    {
        return objeto;
    }

    protected void setObjeto(T pT)
    {
        objeto = pT;
    }

    public List<T> getLista()
    {
        return lista;
    }

    public void setLista(List<T> pLista)
    {
        lista = pLista;
    }
}
