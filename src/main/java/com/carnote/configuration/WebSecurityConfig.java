package com.carnote.configuration;

import com.carnote.authentication.MyDBAuthenticationService;
import com.carnote.configuration.https.HttpsEnforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import javax.servlet.Filter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {

        return new MyDBAuthenticationService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public Filter httpsEnforcerFilter(){
        return new HttpsEnforcer();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Users in memory.
        auth.inMemoryAuthentication()
                .withUser("admin1").password(passwordEncoder().encode("admin1_pass")).roles("ADMIN");

        // For User in database.
        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                // The pages does not require login
                .antMatchers("/resources/static/**").permitAll()
                // For USER only.
                .antMatchers("/**").access("hasRole('USER')")
                // Config for Login Form
                .and()
                    .formLogin()
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password")
                .and()
                    .exceptionHandling().accessDeniedPage("/403")
                // Config for Logout Page
                .and()
                    .logout().logoutUrl("/logout")
                    .logoutSuccessUrl("/index")
                // Config for Remember Me
                .and()
                    .rememberMe().key("uniqueAndSecret");
    }
}