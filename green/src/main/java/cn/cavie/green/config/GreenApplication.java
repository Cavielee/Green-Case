package cn.cavie.green.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@PropertySource(value = { "classpath:db.properties","classpath:log4j2.properties",
		"classpath:ValidationMessages.properties" }, ignoreResourceNotFound = true)
@ComponentScan(basePackages = "cn.cavie.green")
@ServletComponentScan(basePackages = "cn.cavie.green")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class GreenApplication extends SpringBootServletInitializer {

	// 数据库驱动
	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	// 相应驱动的jdbcUrl
	@Value("${jdbc.url}")
	private String url;

	// 数据库的用户名
	@Value("${jdbc.username}")
	private String username;

	// 数据库的密码
	@Value("${jdbc.password}")
	private String password;

	// 数据库的最大连接数
	@Value("${jdbc.maxActive}")
	private int maxActive;

	// 数据库的最大空闲连接
	@Value("${jdbc.maxIdle}")
	private int maxIdle;

	// 数据库连接池dbcp
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// 数据库驱动
		dataSource.setDriverClassName(driverClassName);
		// 相应驱动的jdbcUrl
		dataSource.setUrl(url);
		// 数据库的用户名
		dataSource.setUsername(username);
		// 数据库的密码
		dataSource.setPassword(password);
		// 数据库的最大连接数
		dataSource.setMaxActive(maxActive);
		// 数据库的最大空闲连接
		dataSource.setMaxIdle(maxIdle);
		return dataSource;
	}

	//显示声明CommonsMultipartResolver为mutipartResolver  
    @Bean(name = "multipartResolver")  
    public MultipartResolver multipartResolver() {  
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();  
        resolver.setDefaultEncoding("UTF-8");  
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常  
        resolver.setMaxInMemorySize(40960);  
        resolver.setMaxUploadSize(100 * 1024 * 1024);//上传文件大小100M 5*1024*1024  
        return resolver;  
    }
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GreenApplication.class);
	}
}
