package com.robosh.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import javax.sql.DataSource;

import static com.robosh.common_routes.Routes.*;
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
                .antMatchers(ADMIN_MAPPING + "/**").hasAuthority(ADMIN.name())
                .antMatchers( STUDENT_MAPPING + "/**").hasAuthority(STUDENT.name())
                .antMatchers(PARENT_MAPPING + "/**").hasAuthority(PARENT.name())
                .antMatchers(TEACHER_MAPPING + "/**").hasAuthority(TEACHER.name())
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