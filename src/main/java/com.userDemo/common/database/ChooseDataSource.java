package com.userDemo.common.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
public class ChooseDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {

        return HandleDataSource.getDataSource();
    }

}