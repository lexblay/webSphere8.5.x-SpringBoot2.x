package com.was;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setPackagesToScan("com.*");
		emfBean.setPersistenceUnitName("persistenceWas");
		emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emfBean.setDataSource(dataSource);
		return emfBean;
		
	}

}
