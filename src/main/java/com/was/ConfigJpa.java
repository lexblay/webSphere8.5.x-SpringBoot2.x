package com.was;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ConfigJpa {

	@Autowired
	private DataSource dataSource;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateDdlAuto;

	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setPackagesToScan("com.*");
		emfBean.setPersistenceUnitName("persistenceUnit");
		emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emfBean.setDataSource(dataSource);
		emfBean.setJpaProperties(additionalProperties());

		return emfBean;
	}

	Properties additionalProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", hibernateDdlAuto);
		jpaProperties.setProperty("hibernate.dialect", dialect);
		return jpaProperties;
	}

}
