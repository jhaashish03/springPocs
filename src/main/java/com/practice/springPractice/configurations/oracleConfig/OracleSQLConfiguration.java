package com.practice.springPractice.configurations.oracleConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "oracleSQLEntityManager",
        transactionManagerRef = "oracleSQLPlatformTransactionManager",
        basePackages = {"com.practice.springPractice.repositories.oracleSqlRepo"}

)
public class OracleSQLConfiguration {
    @Autowired
    private Environment environment;


    @Bean("oracleSQLDatasource")
    @Primary
    public DataSource dataSource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setUrl(Objects.requireNonNull(environment.getProperty("oracle.datasource.url")));
        dataSource.setUsername(environment.getProperty("oracle.datasource.username"));
        dataSource.setPassword(environment.getProperty("oracle.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty("oracle.datasource.driver-class-name"));
        return dataSource;

    }

    @Bean("oracleSQLEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        Map<String,String> map=new HashMap<>();
//        map.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
        map.put("hibernate.show.sql","true");
        map.put("hibernate.format_sql", "true");
        map.put("hibernate.generate_statistics", "true");
        map.put("hibernate.ddl-auto", "update");
        entityManagerFactoryBean.setJpaPropertyMap(map);
        entityManagerFactoryBean.setPackagesToScan("com.practice.springPractice.entity.oracleSqlEntities");
      entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactoryBean;
    }

    @Bean("oracleSQLPlatformTransactionManager")
    public PlatformTransactionManager platformTransactionManager(){
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean().getObject()));
    }
}
