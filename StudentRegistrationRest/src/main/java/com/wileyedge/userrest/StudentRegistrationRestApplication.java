package com.wileyedge.userrest;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
@ComponentScan(basePackages = "com.wileyedge.userrest")
@PropertySource("classpath:mysql.properties")
public class StudentRegistrationRestApplication {

	@Autowired
	//The config data in mysql.properties is added in Environment, if @PropertySource("classpath:mysql.properties") is given
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentRegistrationRestApplication.class, args);
	}

	/*@Bean
	@ConditionalOnMissingBean
	public DataSource dataSource() {
		System.out.println("Inside datasource method");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/reststu?createDatabaseIfNotExist=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;

	}
	//CONDITIONALONBEAN v
	/*include entityManagerFactory bean only if a dataSource bean is present. sequence matters.define dataSource bean prior. */
	/*@Bean(name = "entityManagerFactory")
	@ConditionalOnBean(name = "dataSource")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println("Inside entityManagerFactory method");
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.wileyedge.*");
		
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());

		return em;
	}
	
	public Properties additionalProperties() {
		System.out.println("Inside additionalProperties method");
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",env.getProperty("mysql-hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("mysql-hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("mysql-hibernate.show_sql"));
		
		return hibernateProperties;
	}*/
	
}
