package by.malinovski.book;

import by.malinovski.book.service.UserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(
            "/",
            "/home",
            "/userRegistration",
            "/lib/bootstrap/**",
            "/css/**",
            "/scss/**",
            "/image/**",
            "/images/**",
            "/fonts/**",
            "/js/**",
            "/addPhoto",
            "/actuator/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/")
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .logout() // logout configuration
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
        .deleteCookies("JSESSIONID")
        .and()
        .exceptionHandling() // exception handling configuration
        .accessDeniedPage("/accessDeniedPage")
        .and()
        .rememberMe()
        .key("uniqueAndSecret")
        .rememberMeParameter("remember-me")
        .rememberMeCookieName("booki-remember-me")
        .tokenValiditySeconds(7 * 24 * 60 * 60);
  }
  //    https://www.baeldung.com/registration-with-spring-mvc-and-spring-security

  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl();
  }

  @Override // TODO GM: is i need it?
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/resources/**");
  }
}
