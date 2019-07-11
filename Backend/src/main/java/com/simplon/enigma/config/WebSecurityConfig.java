package com.simplon.enigma.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * @author Fadi NOUFAL
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login", "/security/authError",
                        "/security/login", "/security/logout", "/users",
                        "/users/dashboard","/users/saveScore","/users/page",
                        "/users/userProfile","/users/saveScores")
                .permitAll().and().formLogin().loginPage("/security/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/security/me", true)
                .failureUrl("/security/authError").and().logout()
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/security/logout").and()
                .authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    protected WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowCredentials(true)
                        .maxAge(3600L);
            }
        };
    }
}
