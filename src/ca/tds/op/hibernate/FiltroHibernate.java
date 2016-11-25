package ca.tds.op.hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroHibernate implements Filter
{
    public FiltroHibernate()
    {
    }

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pSequencia) throws IOException, ServletException
    {
        try
        {
            HibernateUtil.iniciarTransacao();

            HttpServletRequest tRequest = (HttpServletRequest) pRequest;
            System.out.println("Servlet Ativado : " + tRequest.getRequestURI());

            pSequencia.doFilter(pRequest, pResponse);

            HibernateUtil.confirmarTransacao();
        }
        catch (Exception tExcept)
        {
            HibernateUtil.cancelarTransacao();
            tExcept.printStackTrace();
            throw new ServletException(tExcept);
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException
    {
    }
}
