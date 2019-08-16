package com.examplespringboot.demo.Security;



import com.examplespringboot.demo.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoders() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoders());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .antMatcher("/admin/**")
            .authorizeRequests();
//            .antMatchers("/admin/**")
//            .hasAnyRole("ADMIN", "TEACHER")
//            .anyRequest().permitAll()
//            .and()
//            .formLogin()
//            //submit url của trang login
//            .loginPage("/auth/login")
//            .loginProcessingUrl("/admin/login")
//            .usernameParameter("email")
//            .passwordParameter("password")
//            .defaultSuccessUrl("/admin/user")
//            .failureUrl("/auth/login?error=deny")
//            .and()
//            .logout()
//            .logoutUrl("/admin/logout")
//            .logoutSuccessUrl("/auth/login")
//            .deleteCookies("JSESSIONID")
//            .and()
//            .exceptionHandling()
//            .accessDeniedPage("/admin/403");
    }


}
