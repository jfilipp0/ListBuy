package ca.tds.op.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonUtil
{
    public static String enviarPost(String pUrl, String pDados)
    {
        try
        {
            // Montando o objeto de conexão
            URL tUrl = new URL(pUrl);

            // Abrindo a conexão e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setDoOutput(true);
            tConexao.setRequestMethod("POST");
            tConexao.setRequestProperty("Content-Type", "application/json");

            // Obtendo o canal de gravação e mandando os dados recebidos
            OutputStream tCanalSaida = tConexao.getOutputStream();
            tCanalSaida.write(pDados.getBytes());
            tCanalSaida.flush();

            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    public static String enviarPut(String pUrl, String pDados)
    {
        try
        {
            // Montando o objeto de conexão
            URL tUrl = new URL(pUrl);

            // Abrindo a conexão e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setDoOutput(true);
            tConexao.setRequestMethod("PUT");
            tConexao.setRequestProperty("Content-Type", "application/json");

            // Obtendo o canal de gravação e mandando os dados recebidos
            OutputStream tCanalSaida = tConexao.getOutputStream();
            tCanalSaida.write(pDados.getBytes());
            tCanalSaida.flush();

            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    public static String enviarGet(String pUrl)
    {
        try
        {
            // Montando o objeto de conexão
            URL tUrl = new URL(pUrl);

            // Abrindo a conexão e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setRequestMethod("GET");
            tConexao.setRequestProperty("Accept", "application/json");

            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    public static String enviarDelete(String pUrl)
    {
        try
        {
            // Montando o objeto de conexão
            URL tUrl = new URL(pUrl);

            // Abrindo a conexão e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setRequestMethod("DELETE");
            tConexao.setRequestProperty("Accept", "application/json");

            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    private static String processarResposta(HttpURLConnection tConexao) throws IOException
    {
        // Verificando se o retorno foi OK
        if (tConexao.getResponseCode() != HttpURLConnection.HTTP_OK)
        {
            throw new RuntimeException("Erro na conexão : Código de erro HTTP : " + tConexao.getResponseCode());
        }

        // Obtendo o canal de leitura da resposta
        BufferedReader tResposta = new BufferedReader(new InputStreamReader(tConexao.getInputStream()));

        // Lendo as linhas e concatenando
        String tSaida = "";
        while (true)
        {
            String tLinha = tResposta.readLine();
            if (tLinha == null)
                break;
            tSaida += tLinha;
        }

        // Fechando a conexão
        tConexao.disconnect();
        return tSaida;
    }
}
