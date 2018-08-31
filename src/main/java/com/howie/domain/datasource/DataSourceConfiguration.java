package com.howie.domain.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

	@Value("${druid.type}")
	private Class<? extends DataSource> dataSourceType;
	
	@Bean(name="masterDataSource")
	@Primary
	@ConfigurationProperties(prefix="druid.master.datasource")
	public DataSource masterDataSource(){
		DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
		return masterDataSource;
	}
	
	@Bean(name="clusterDataSource")
	@ConfigurationProperties(prefix="druid.cluster.datasource")
	public DataSource clusterDataSource(){
		DataSource clusterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
		return clusterDataSource;
	}
	
}