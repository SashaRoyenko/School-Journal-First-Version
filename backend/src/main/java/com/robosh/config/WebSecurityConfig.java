package com.robosh.config;


import org.springframework.beans.factory.annotation.Autowired;
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

import static com.robosh.common_routes.Routes.E_JOURNAL;
import static com.robosh.data.enumeration.Role.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Autowired
    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", E_JOURNAL)
                .permitAll()
                .antMatchers(E_JOURNAL + "/admin/**").hasAuthority(ADMIN.name())
                .antMatchers(E_JOURNAL + "/student/**").hasAuthority(STUDENT.name())
                .antMatchers(E_JOURNAL + "/parent/**").hasAuthority(PARENT.name())
                .antMatchers(E_JOURNAL + "/teacher/**").hasAuthority(TEACHER.name())
                .antMatchers("/*")
                .authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage(E_JOURNAL + "/login")
                .defaultSuccessUrl("/default", true)
                .failureUrl(E_JOURNAL + "/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl(E_JOURNAL)
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage(E_JOURNAL + "/access-denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //todo replace with some encoder
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
