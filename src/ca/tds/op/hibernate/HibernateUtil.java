package ca.tds.op.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
    private static final String          PROBLEMA_CRIACAO_SESSION_FACTORY = "Problema na criação da classe SessionFactory. ";
    private static final String          ARQUIVO_CONFIGURACAO             = "hibernate.cfg.xml";
    private static final ServiceRegistry mServiceRegistry;
    private static final SessionFactory  mSessionFactory;

    static
    {
        try
        {
            // Criando o objeto para configuração
            Configuration tConfiguracao = new Configuration();
            tConfiguracao.configure(ARQUIVO_CONFIGURACAO);

            // Criando o serviço de registro e o objeto SessionFactory
            mServiceRegistry = new StandardServiceRegistryBuilder()
                                      .applySettings(tConfiguracao.getProperties())
                                      .build();
            mSessionFactory = tConfiguracao.buildSessionFactory(mServiceRegistry);
        }
        catch (Throwable tExcept)
        {
            System.err.println(PROBLEMA_CRIACAO_SESSION_FACTORY + tExcept);
            throw new ExceptionInInitializerError(tExcept);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return mSessionFactory;
    }

    public static void iniciarTransacao()
    {
        SessionFactory tFactory = HibernateUtil.getSessionFactory();
        Session tSessao = tFactory.getCurrentSession();
        Transaction tTransacao = tSessao.getTransaction();
        tTransacao.begin();
    }

    public static void confirmarTransacao()
    {
        SessionFactory tFactory = HibernateUtil.getSessionFactory();
        Session tSessao = tFactory.getCurrentSession();
        Transaction tTransacao = tSessao.getTransaction();
        tTransacao.commit();
    }

    public static void cancelarTransacao()
    {
        SessionFactory tFactory = HibernateUtil.getSessionFactory();
        Session tSessao = tFactory.getCurrentSession();
        Transaction tTransacao = tSessao.getTransaction();
        tTransacao.rollback();
    }

    public static void fecharConexao()
    {
        SessionFactory tFactory = HibernateUtil.getSessionFactory();
        tFactory.close();
    }
}
