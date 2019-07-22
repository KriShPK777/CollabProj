package com.pk.Config;

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

import com.pk.Model.Blog;
import com.pk.Model.BlogComment;
import com.pk.Model.Friend;
import com.pk.Model.Job;
import com.pk.Model.UserDetail;

@Configuration
@ComponentScan("com.pk")
@EnableTransactionManagement
public class DBConfig
{
    public DataSource getOracleDataSource()
    {
    	DriverManagerDataSource dataSource=new DriverManagerDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    	dataSource.setUsername("orcl");
    	dataSource.setPassword("Krishna777");
    	System.out.println("---DataSource Created---");
    	return dataSource;
    }
    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory()
    {
    	Properties hibernateProperties=new Properties();
    	
    	hibernateProperties.put("hibernate.hbmddl2.auto", "update");
    	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle11gDialect");
    	hibernateProperties.setProperty("hibernate.show_sql", "true");
    	
    	LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(this.getOracleDataSource());
    	factory.addProperties(hibernateProperties);
    	
    	factory.addAnnotatedClass(Blog.class);
    	factory.addAnnotatedClass(BlogComment.class);
    	factory.addAnnotatedClass(Job.class);
    	factory.addAnnotatedClass(UserDetail.class);
    	factory.addAnnotatedClass(Friend.class);
    	
    	SessionFactory sessionFactory=factory.buildSessionFactory();
    	System.out.println("==========Created SessionFactory========");
    	
    	return sessionFactory;
    		
    }
    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
    {
    	System.out.println("======== Hibernate Transaction Manager==========");
    	return new HibernateTransactionManager(sessionFactory);
    }
    
}
