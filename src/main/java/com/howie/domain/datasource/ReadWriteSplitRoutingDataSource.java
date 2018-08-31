package com.howie.domain.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<DBType> contextHolder = new ThreadLocal<DBType>();
	
	/*@Override
    public void afterPropertiesSet() {
		setDefaultTargetDataSource();
	}*/
	
	@Override
	protected Object determineCurrentLookupKey() {
		return getDBType();
	}

	public enum DBType {
		MASTER, CLUSTER
	}

	public static void setDbType(DBType dbType) {
		if (dbType == null)
			throw new NullPointerException();
		contextHolder.set(dbType);
	}

	public static DBType getDBType() {
		return contextHolder.get() == null ? DBType.MASTER : contextHolder.get();
	}

	public static void clearDbType() {
		contextHolder.remove();
	}

}
