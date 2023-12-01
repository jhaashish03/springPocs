package com.practice.springPractice.configurations.mysqlConfig;


import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
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
        entityManagerFactoryRef = "mysqlEntityManager",
        transactionManagerRef = "mysqlPlatformTransactionManager",
        basePackages = {"com.practice.springPractice.repositories.mysqlRepo"}

)
public class MySQLConfiguration {


    @Autowired
    private Environment environment;


    @Bean("mysqlDatasource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setUrl(Objects.requireNonNull(environment.getProperty("mysql.datasource.url")));
        dataSource.setUsername(environment.getProperty("mysql.datasource.username"));
        dataSource.setPassword(environment.getProperty("mysql.datasource.password"));
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return dataSource;

    }

    @Bean("mysqlEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        Map<String,String> map=new HashMap<>();
//        map.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        map.put("hibernate.show.sql","true");
        map.put("hibernate.format_sql", "true");
        map.put("hibernate.generate_statistics", "true");
        map.put("hibernate.ddl-auto", "create");


        entityManagerFactoryBean.setJpaPropertyMap(map);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        entityManagerFactoryBean.setPackagesToScan("com.practice.springPractice.entity.mysqlEntities");
        return entityManagerFactoryBean;
    }

@Bean("mysqlPlatformTransactionManager")
@Primary
    public PlatformTransactionManager platformTransactionManager(){
    return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean().getObject()));
}

}
