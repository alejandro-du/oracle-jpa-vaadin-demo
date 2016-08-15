package com.example;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;

@DataSourceDefinition(
        name = "java:app/demo/DemoDS",
        className = "oracle.jdbc.pool.OracleDataSource",
        url = "jdbc:oracle:thin:@localhost:1521:xe",
        user = "demo",
        password = "password"
)
@Stateless
public class DatasourceConfig {
}
