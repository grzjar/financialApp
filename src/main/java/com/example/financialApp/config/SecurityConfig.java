package com.example.financialApp.config;

import com.example.financialApp.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService userDetailsService;

    public SecurityConfig(CustomUserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    //wystawienie beana do encodowania hasła - resetowanie hasła - nie ma możliwości edycji hasła
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //uwierzytelnienie użytkownika
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //proces autoryzacji
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/blad").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/create").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/logged/*").hasRole("USER")
                //TODO Nie stosować takich zapisów
                //     Zabezpieczenia ogólne, "odbezpieczenia" szczegółowe
                .antMatchers("/*").permitAll()
                .antMatchers("/images/*").permitAll()
                .anyRequest().authenticated() //gdybyśmy o czymś zapomnieli to lepiej pozostawić to tu - musi być na końcu
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/logged/")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .disable();

    }


}
