package com.coll.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Friend;
import com.coll.model.Job;
import com.coll.model.UserDetail;

	@Configuration	
	@ComponentScan(basePackages="com.coll")
	@EnableTransactionManagement
	public class DBConfig {
		
			
			@Bean(name="dataSource")
			public DataSource getDataSource()
			{
				DriverManagerDataSource dataSource=new DriverManagerDataSource();
				dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
				dataSource.setUrl("jdbc:oracle:thin:vashnavi@//localhost:1521/orcl");
				dataSource.setUsername("vashnavi");
				dataSource.setPassword("oracle");
				return dataSource;
			}
			
			@Bean(name="sessionFactory")
			public SessionFactory getSessionFactory(DataSource dataSource)
			{
				LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getDataSource());
				Properties prop=new Properties();
				prop.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
				prop.put("hibernate.hbm2ddl.auto", "update");//fix
				prop.put("hibernate.show_sql", "true");//fix
				prop.put("hibernate.format_sql", "true");//fix
				lsfb.addProperties(prop);
				lsfb.scanPackages("com.coll");//fix
				SessionFactory sessionFactory=lsfb.buildSessionFactory();
				
				return sessionFactory;
			}

			@Bean("txMmanager")
			public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
			{
				
			return new HibernateTransactionManager(sessionFactory);	
			
	}
	}



