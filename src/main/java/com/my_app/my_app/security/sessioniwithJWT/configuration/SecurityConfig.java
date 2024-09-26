package com.my_app.my_app.security.sessioniwithJWT.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.my_app.my_app.security.sessioniwithJWT.JWT.JwtRequestFilter;
import com.my_app.my_app.security.sessioniwithJWT.Service.UsersDetailSer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsersDetailSer detailSer; // Iniezione del tuo UserDetailsService
    @Autowired
    private JwtRequestFilter jwtRequestFilter; //Per jwt

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(withDefaults()) // Abilita la protezione per il CSRF
                .authorizeHttpRequests(auth -> auth // Usa il lambda per autorizzare le richieste
                                .requestMatchers("/login", "/register").permitAll() // Permetti accesso pubblico a queste rotte
                                .requestMatchers("/admin/**").hasRole("ADMIN") // Solo Admin
                                .requestMatchers("/seller/**").hasRole("SELLER") // Solo Seller
                                .requestMatchers("/controller/**").hasRole("CONTROLLER") // Solo Controller
                                .requestMatchers("/delivery/**").hasRole("DELIVERY") // Solo Delivery
                                .requestMatchers("/payment/**").hasRole("PAYMENTMAN") // Solo PaymentMan
                                .requestMatchers("/user/**").hasAnyRole("USER", "SELLER", "ADMIN", "CONTROLLER", "DELIVERY", "PAYMENTMAN") // Accesso per utenti generali
                                .anyRequest().authenticated()
                                .anyRequest().authenticated() // Richiedi autenticazione per le altre richieste
                                
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class) //Aggiungiamo jwt
                .formLogin(form -> form // Configurazione del login tramite form
                                .loginPage("/login") // Pagina di login personalizzata
                                .permitAll()
                )
                .logout(logout -> logout // Configurazione per il logout
                                .permitAll()
                )
                .sessionManagement(session -> session // Configurazione della gestione delle sessioni
                                .maximumSessions(1) // Limita il numero di sessioni per utente
                                .sessionRegistry(sessionRegistry()) // Imposta il registry delle sessioni
                );

        return http.build(); // Costruisci e ritorna l'oggetto SecurityFilterChain
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // Per criptare la password dell'utente
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailSer) // Imposta il tuo UserDetailsService
            .passwordEncoder(passwordEncoder()); // Imposta il password encoder
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl(); // Implementazione del registro delle sessioni
    }


    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() { //Per impostare la temporalità della sessione, vedi nelle properties
     return new HttpSessionEventPublisher();
  }
}