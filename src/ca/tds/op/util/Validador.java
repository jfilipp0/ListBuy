package ca.tds.op.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Validador
{
    /* Atributos estáticos */
    private static final Pattern PADRAO_EMAIL = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    /* Métodos estáticos */
    //
    // Método para verificar se o parâmetro é alfanumérico
    //
    public static boolean alfanumerico(String pTexto)
    {
        if (pTexto == null)
            return false;

        for (int i = 0; i < pTexto.length(); i++)
        {
            if (Character.isLetterOrDigit(pTexto.charAt(i)) == false &&
                            pTexto.charAt(i) != '.' &&
                            pTexto.charAt(i) != ' ' &&
                            pTexto.charAt(i) != '\'')
                return false;
        }
        return true;
    }

    //
    // Método para verificar se o parâmetro é alfabético
    //
    public static boolean alfabetico(String pTexto)
    {
        if (pTexto == null)
            return false;

        for (int i = 0; i < pTexto.length(); i++)
        {
            if (Character.isLetter(pTexto.charAt(i)) == false &&
                            pTexto.charAt(i) != '.' &&
                            pTexto.charAt(i) != ' ' &&
                            pTexto.charAt(i) != '\'')
                return false;
        }
        return true;
    }

    //
    // Método para verificar se o parâmetro é numérico
    //
    public static boolean numerico(String pTexto)
    {
        if (pTexto == null)
            return false;

        if (pTexto.length() == 0)
            return true;

        int i = 0;
        if (pTexto.charAt(0) == '+' ||
                        pTexto.charAt(0) == '-')
            i = 1;
        for (; i < pTexto.length(); i++)
        {
            if (!Character.isDigit(pTexto.charAt(i)))
                return false;
        }
        return true;
    }

    //
    // Método para verificar se o parâmetro é numérico real, aceita o ponto
    //
    public static boolean numericoReal(String pTexto)
    {
        if (pTexto == null)
            return false;

        if (pTexto.length() == 0)
            return true;

        if (pTexto.charAt(0) == '.')
            return false;

        boolean tDecimal = false;
        int i = 0;
        if (pTexto.charAt(0) == '+' ||
                        pTexto.charAt(0) == '-')
            i = 1;
        for (; i < pTexto.length(); i++)
        {
            if (!Character.isDigit(pTexto.charAt(i)) &&
                            pTexto.charAt(i) != '.')
                return false;
            if (pTexto.charAt(i) == '.' && tDecimal)
                return false;
            if (pTexto.charAt(i) == '.')
                tDecimal = true;
        }
        return true;
    }

    //
    // Método para verificar se o parâmetro é uma data válida de acordo com o padrão informado
    //
    public static boolean validarData(String pFormato, String pData)
    {
        if (pFormato == null || pData == null)
            return false;

        try
        {
            SimpleDateFormat tFormat = new SimpleDateFormat(pFormato);
            tFormat.setLenient(false);
            tFormat.parse(pData);
            return true;
        }
        catch (ParseException e)
        {
            return false;
        }
    }

    //
    // Método sobrecarregado de validarData, que assume o padrão Brasileiro
    //
    public static boolean validarData(String pData)
    {
        return validarData("dd'/'MM'/'yyyy", pData);
    }

    //
    // Método para validar se um e-mail está ok
    //
    public static boolean validarEmail(String pEmail)
    {
        return PADRAO_EMAIL.matcher(pEmail).matches();
    }
}
