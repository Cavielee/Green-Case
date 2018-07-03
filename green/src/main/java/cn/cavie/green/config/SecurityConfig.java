package cn.cavie.green.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new Md5PasswordEncoder();
	}
	
	
	/**
	 *  相当于xml的authentication-manager
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.eraseCredentials(true)
			.jdbcAuthentication()
				.passwordEncoder(passwordEncoder())
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?")
				.authoritiesByUsernameQuery("SELECT username, authority FROM USER NATURAL JOIN user_authorities NATURAL JOIN authorities WHERE username = ?")
				.rolePrefix("ROLE_");
		
	}

	/**
	 * 相当于<http pattern="/js/**" security="none" />
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/js/**")
				.antMatchers("/img/**")
				.antMatchers("/css/**")
				.antMatchers("/*.jpg")
				.antMatchers("/*.png")
				.antMatchers("/*.svg")
				.antMatchers("/green.jsp");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/index")
				.loginProcessingUrl("/check_login")
				.passwordParameter("password")
				.usernameParameter("username")
		.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/user")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
		
//		.and()
//			.authorizeRequests()
//				// 上传图片
//				.antMatchers("/uploadImage").hasAnyRole("ADMIN","ORDERWORK","GOODSWORK","USER")
//				// 有关订单处理的
//				.antMatchers("/untreatedOrders").hasAnyRole("ADMIN","ORDERWORK")
//				.antMatchers("/untreatedOrderDetail").hasAnyRole("ADMIN","ORDERWORK")
//				.antMatchers("/orderRecycle").hasAnyRole("ADMIN","ORDERWORK")
//				// 有关商品处理的
//				.antMatchers("/goodsManage").hasAnyRole("ADMIN","GOODSWORK")
//				.antMatchers("/toCreateGoods").hasAnyRole("ADMIN","GOODSWORK")
//				.antMatchers("/createGoods").hasAnyRole("ADMIN","GOODSWORK")
//				.antMatchers("/deleteGoods").hasAnyRole("ADMIN","GOODSWORK")
//				.antMatchers("/pointGoodsManage").hasAnyRole("ADMIN","GOODSWORK")
//				.antMatchers("/toCreatePointGoods").hasAnyRole("ADMIN","GOODSWORK")
//				.antMatchers("/createPointGoods").hasAnyRole("ADMIN","GOODSWORK")
//				.antMatchers("/deletePointGoods").hasAnyRole("ADMIN","GOODSWORK")
//				// 有关角色处理的
//				.antMatchers("/orderWorks").hasAnyRole("ADMIN")
//				.antMatchers("/goodsWorks").hasAnyRole("ADMIN")
//				.antMatchers("/deleteWorks").hasAnyRole("ADMIN")
//				.antMatchers("/toCreateWork").hasAnyRole("ADMIN")
//				.antMatchers("/createWork").hasAnyRole("ADMIN")
//				
//				.antMatchers("/index").permitAll()
//				.antMatchers("/user").permitAll()
//				.antMatchers("/sale").permitAll()
//				.antMatchers("/point").permitAll()
//				.antMatchers("/pointGoodsList/*").permitAll()
//				.antMatchers("/video").permitAll()
//				.antMatchers("/error/**").permitAll()
//				.antMatchers("/undefined").permitAll()
//				
//				.antMatchers("/login").anonymous()
//				.antMatchers("/regedit*").anonymous()
//				.antMatchers("/createValidateCode").anonymous()
				
//				.antMatchers("/**").hasRole("USER")
				
		.and()
			.rememberMe()
				.rememberMeParameter("remember-me")
				.tokenValiditySeconds(86400)
		.and()
			.sessionManagement()
				.sessionFixation().migrateSession()
				.maximumSessions(1)
				.expiredUrl("/error/expired")
				.maxSessionsPreventsLogin(false);
	}
	
	
}
