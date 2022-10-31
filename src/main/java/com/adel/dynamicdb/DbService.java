package com.adel.dynamicdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DbService {

    private Map<String, DataSource> dataSources;

    @Autowired
    @Qualifier("dataSources")
    public void setDataSources(Map<String, DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public void connect(){
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSources.get("db1"));
    }

}
