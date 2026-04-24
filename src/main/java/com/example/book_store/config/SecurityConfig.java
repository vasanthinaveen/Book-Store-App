package com.example.book_store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailService(PasswordEncoder passwordEncoder)
    {
        UserDetails userDetailsOne= User.withUsername("root1").password(passwordEncoder.encode("secret1")).roles("USER").build();
        UserDetails userDetailsTwo= User.withUsername("root2").password(passwordEncoder.encode("secret2")).roles("USER").build();
        UserDetails userDetailsAdmin= User.withUsername("admin").password(passwordEncoder.encode("adminsecret")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(userDetailsOne,userDetailsTwo,userDetailsAdmin);
    }
    @Bean
    PasswordEncoder passEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("/book-store/welcome","user-info/register").permitAll().anyRequest().authenticated());
        httpSecurity.httpBasic(Customizer.withDefaults());

    httpSecurity.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
return httpSecurity.build();
    }
}
