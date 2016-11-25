package ca.tds.op.hibernate;

import java.sql.Types;

import org.hibernate.dialect.Oracle10gDialect;

public class Oracle10gDialectExtended extends Oracle10gDialect {


    protected void registerNumericTypeMappings() {
        super.registerNumericTypeMappings();
        registerColumnType( Types.DOUBLE, "number" );
    }

}