package com.pk.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pk.Model.Blog;
import com.pk.Model.BlogComment;
import com.pk.Model.Friend;
import com.pk.Model.Job;
import com.pk.Model.Message;
import com.pk.Model.OutputMessage;
import com.pk.Model.ProfilePicture;
import com.pk.Model.UserDetail;

@Configuration
@EnableTransactionManagement
public class ConfigDB 
{
	public ConfigDB(){
		System.out.println("-----DBCOnfiguration class instantiated----------");
	}
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		System.out.println("----Session Factory Object created-----");
	Class classes[]=new Class[]{UserDetail.class,Blog.class,BlogComment.class,Job.class,Message.class,OutputMessage.class,ProfilePicture.class,Friend.class};
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	    dataSource.setUsername("krishna");
	    dataSource.setPassword("Krishna777");
	    System.out.println("--Data source created-----");
	    return dataSource;
	    
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		System.out.println("---Transaction Management created-------");
		return new HibernateTransactionManager(sessionFactory());
	}

}


