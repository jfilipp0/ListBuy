package ca.tds.op.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionUtil
{

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
