/*
 * Conexao.java
 *
 * Classe que faz e armazena a conexão com o banco de dados via JDBC
 *
 * © 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Histórico
 * 14/07/2016 – Versão 1.0 - José Augusto – Criação do arquivo
 *
 */
package ca.tds.op.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Conexao
{
    /* Atributos estáticos */
    private static Connection sConexao;

    /* Métodos estáticos */
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("Obtendo a conexão");
        getConexao();

        System.out.println();
        System.out.println("Fechando a conexão");
        getConexao();
    }


    /* Métodos da classe */
    public static Connection getConexao()
    {
        try
        {
            // Caso a conexão já exista, verifica se está aberta e retorna ela
            if (sConexao != null)
            {
                if (!sConexao.isClosed())
                    return sConexao;
            }

            // Carregando o arquivo de configuração do JDBC para as propriedades
            InputStream tArqEntrada = Conexao.class.getResourceAsStream("jdbc.properties");;
            if (tArqEntrada == null)
                throw new IOException("Arquivo de configuração 'jdbc.properties' não existe no diretório do pacote");
            Properties tPropriedades = new Properties();
            tPropriedades.load(tArqEntrada);
            tArqEntrada.close();

            // Recuperando as propriedades do arquivo e validando se estão ok
            String tDriver = tPropriedades.getProperty("driver");
            if (tDriver == null || tDriver.isEmpty())
                throw new InvalidPropertiesFormatException("Propriedade 'driver' não existe ou em branco no arquivo 'jdbc.properties'");
            String tURL = tPropriedades.getProperty("url");
            if (tURL == null || tURL.isEmpty())
                throw new InvalidPropertiesFormatException("Propriedade 'url' não existe ou em branco no arquivo 'jdbc.properties'");
            String tNomeLog = tPropriedades.getProperty("log");
            String tUsuario = tPropriedades.getProperty("usuario");
            String tSenha = tPropriedades.getProperty("senha");

            // Assinalando o arquivo de log, caso ele esteja configurado
            if (tNomeLog != null && !tNomeLog.isEmpty())
            {
                PrintWriter tLog = new PrintWriter(new FileWriter(tNomeLog, true));
                DriverManager.setLogWriter(tLog);
                DriverManager.println("|-------> Iniciando log.....");
            }

            // Carregando o driver e fazendo a conexão com o banco de dados
            DriverManager.println("|-------> Registrando o driver.....");
            Class.forName(tDriver);
            DriverManager.println("|-------> Realizando a conexão.....");
            sConexao = DriverManager.getConnection(tURL, tUsuario, tSenha);
            DriverManager.println("|-------> Conexão estabelecida.....");
        }
        catch (ClassNotFoundException tExcept)
        {
            mostrarErro(tExcept, "Classe do Driver não encontrado");
            System.exit(9);
        }
        catch (IOException tExcept)
        {
            mostrarErro(tExcept, "Problemas na criação do arquivo de log");
            System.exit(9);
        }
        catch (SQLException tExcept)
        {
            mostrarErro(tExcept, "Problemas na conexão com o banco de dados");
            System.exit(9);
        }
        return sConexao;
    }

    public static void desconectar()
    {
        try
        {
            // Desconectando do banco de dados e verificando se a desconex~]ao foi bem realizada
            DriverManager.println("|-------> Fechando a conexão.....");
            sConexao.close();
            DriverManager.println("|-------> Verificando a conexão após fechamento");
            if (sConexao.isClosed())
            {
                DriverManager.println("|-------> Conexão fechada");
            }
            else
            {
                DriverManager.println("|-------> Conexão aberta");
            }
        }
        catch (SQLException tExcept)
        {
            mostrarErro(tExcept, "Problemas no fechamento da conexão com o banco de dados");
            System.exit(9);
        }
    }

    public static void iniciarTransacao()
    {
        try
        {
            sConexao.setAutoCommit(false);
        }
        catch (SQLException tExcept)
        {
            mostrarErro(tExcept, "Problemas no início da tansação com o banco de dados");
            System.exit(9);
        }
    }

    public static void confirmarTransacao()
    {
        try
        {
            sConexao.commit();
            sConexao.setAutoCommit(true);
        }
        catch (SQLException tExcept)
        {
            mostrarErro(tExcept, "Problemas na confimação da transação no banco de dados");
            System.exit(9);
        }
    }

    public static void desfazerTransacao()
    {
        try
        {
            sConexao.rollback();
            sConexao.setAutoCommit(true);
        }
        catch (SQLException tExcept)
        {
            mostrarErro(tExcept, "Problemas para desfazer a tansação no banco de dados");
            System.exit(9);
        }
    }

    public static void mostrarErro(Exception pExcept, String pMsg)
    {
        System.out.println();
        System.out.println(pMsg);
        System.out.println("Exceção....: " + pExcept.getClass().getName());
        System.out.println("Mensagem...: " + pExcept.getMessage());
        if (pExcept instanceof SQLException)
        {
            SQLException tExcept = (SQLException) pExcept;
            System.out.println("SQLState...:" + tExcept.getSQLState());
            System.out.println("Error Code.:" + tExcept.getErrorCode());
            DriverManager.println("SQLState...:" + tExcept.getSQLState());
            DriverManager.println("Error Code.:" + tExcept.getErrorCode());
        }
        Throwable tCausa = pExcept.getCause();
        while (tCausa != null)
        {
            System.out.println("Causa.....: " + tCausa.getMessage());
            tCausa = tCausa.getCause();
        }
        System.out.println("Pilha de execução");
        pExcept.printStackTrace(System.out);
    }
}
