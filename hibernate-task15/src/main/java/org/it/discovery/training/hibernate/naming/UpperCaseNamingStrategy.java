package org.it.discovery.training.hibernate.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(convertName(name.getText()), name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(convertName(name.getText()), name.isQuoted());
    }

    private String convertName(String identifierName) {
        //TODO Insert underscore character before original uppercase symbols
        //createdAt -> CREATED_AT
        // add unit-tests
        return identifierName.toUpperCase();
    }
}
