package com.robosh.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final String BASE_URL = "/e-journal";
    private final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", BASE_URL)
                .permitAll()
                .antMatchers(BASE_URL + "/register-client").anonymous()
                .antMatchers(BASE_URL + "/client-account/**").hasAuthority("USER")
                .antMatchers(BASE_URL+ "/driver-account/**").hasAuthority("STUDENT")
                .antMatchers("/*")
                .authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/taxi-kyiv/login")
                .defaultSuccessUrl("/default", true)
                .failureUrl("/taxi-kyiv/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/taxi-kyiv")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/taxi-kyiv/access-denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select email, password, true from user where email=?")
                .authoritiesByUsernameQuery("select email, role from user where email=?");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web
                .ignoring()
                .antMatchers("/css/**", "/img/**", "/js/**", "/errors/**");
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}
