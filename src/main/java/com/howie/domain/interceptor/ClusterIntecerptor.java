package com.howie.domain.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.howie.domain.annotation.Cluster;
import com.howie.domain.datasource.ReadWriteSplitRoutingDataSource;

@Aspect
@Component
public class ClusterIntecerptor implements Ordered {

	 public static final Logger logger = LoggerFactory.getLogger(ClusterIntecerptor.class); 
	 
	 @Around("@annotation(cluster)") 
	 public Object proceed(ProceedingJoinPoint proceedingJoinPoint,Cluster cluster) throws Throwable {
		 try { 
			 logger.info("set database connection to read only"); 
			 ReadWriteSplitRoutingDataSource.setDbType(ReadWriteSplitRoutingDataSource.DBType.CLUSTER);
			 Object result = proceedingJoinPoint.proceed();
			 return result;
		}finally {
			ReadWriteSplitRoutingDataSource.clearDbType();
			 logger.info("restore database connection");
		}
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}