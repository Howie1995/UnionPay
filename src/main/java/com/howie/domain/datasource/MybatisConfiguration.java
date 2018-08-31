package com.howie.domain.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {

	private static Log logger = LogFactory.getLog(MybatisConfiguration.class);

	@Resource(name = "masterDataSource")
	private DataSource masterDataSource;
	@Resource(name = "clusterDataSource")
	private DataSource clusterDataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		return super.sqlSessionFactory(roundRobinDataSourceProxy());
	}

	public AbstractRoutingDataSource roundRobinDataSourceProxy() {
		ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
		/*Map<Object, Object> targetDataResources =
		  		new ClassLoaderRepository.SoftHashMap();*/
		Map<Object, Object> targetDataResources = new HashMap<Object, Object>();
		targetDataResources.put(ReadWriteSplitRoutingDataSource.DBType.MASTER, masterDataSource);
		targetDataResources.put(ReadWriteSplitRoutingDataSource.DBType.CLUSTER, clusterDataSource);
		//proxy.setDefaultTargetDataSource(masterDataSource);// 默认源
		proxy.setTargetDataSources(targetDataResources);
		proxy.afterPropertiesSet();
		return proxy;
	}

}
