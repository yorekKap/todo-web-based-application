package todor.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Commons;

@Configuration
@EnableJpaRepositories(basePackages="todor.repositories")
@ComponentScan(basePackages = "todor", 	excludeFilters = 
	{@Filter(type = FilterType.ANNOTATION , value = EnableWebMvc.class)})
public class RootConfig  {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter){
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("todor.domain");
		
	
		return factoryBean;
	}
	
	@Bean
	public DataSource dataSource(){
		
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/todor");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("dalglish");
		dataSource.setInitialSize(10);
		dataSource.setMaxTotal(30);
	
		
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVandorAdapter(){
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory){
		
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(factory);
		return tm;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		return resolver;
		
	}
	
    @Bean  
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();  
        source.setBasename("messages");  
        source.setUseCodeAsDefaultMessage(true);  
        return source;  
    }  
	
}
