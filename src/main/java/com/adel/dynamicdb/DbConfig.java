package com.adel.dynamicdb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DbConfig {

    @Value("${datasource}")
    private Map<String, DataSourceDB> dataSourceDBMap;

    @Bean
    @Qualifier("dataSources")
    public Map<String, DataSource> dataSources(){
        final Map<String, DataSource> res = new HashMap<>();
        dataSourceDBMap.forEach((key, value) -> {
            final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(value.getDriverClass());
            dataSourceBuilder.url(value.getUrl());
            dataSourceBuilder.username(value.getUser());
            dataSourceBuilder.password(value.getPassword());
            res.put(key, dataSourceBuilder.build());
        });
        return res;
    }


}
