package com.shiva.springboot.springSecurity1.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.shiva.springboot.springSecurity1.Security.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityconfig extends WebSecurityConfigurerAdapter {



    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityconfig(PasswordEncoder passwordEncoder){

        this.passwordEncoder= passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests()
                .antMatchers("/","index")
                .permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers("/management/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails shiva = User.builder()
                .username("shiva")
                .password(passwordEncoder.encode("test"))
                .roles(STUDENT.name())
                .build();

        UserDetails parvathi = User.builder()
                .username("parvathi")
                .password(passwordEncoder.encode("test"))
                .roles(ADMIN.name())
                .build();

        UserDetails gayathri = User.builder()
                .username("gayathri")
                .password(passwordEncoder.encode("test"))
                .roles(ADMINTRAINEE.name())
                .build();

        return new  InMemoryUserDetailsManager(shiva,parvathi,gayathri);

    }
}
