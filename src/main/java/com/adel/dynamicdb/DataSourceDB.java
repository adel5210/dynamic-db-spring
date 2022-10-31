package com.adel.dynamicdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceDB {

    private String url;
    private String user;
    private String password;
    private String driverClass;

}
