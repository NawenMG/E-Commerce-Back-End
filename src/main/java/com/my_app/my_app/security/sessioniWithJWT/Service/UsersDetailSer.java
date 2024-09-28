package com.my_app.my_app.security.sessioniWithJWT.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.my_app.my_app.dbrel.JPA.Entity.Users;
import com.my_app.my_app.dbrel.JPA.Repository.Inizializzazione.UsersS;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersDetailSer implements UserDetailsService {

    @Autowired
    private UsersS usersS; // Utilizza il repository per accedere ai dati

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersS.findByUsername(username); 
        if (user == null) {
            throw new UsernameNotFoundException("Utente non trovato: " + username);
        }

        // Mappa i ruoli dell'utente in SimpleGrantedAuthority
        List<SimpleGrantedAuthority> authorities = user.getRuolo()
                .stream()
                .map(ruolo -> new SimpleGrantedAuthority(ruolo.name())) // Usa il nome del ruolo come autorità, vedi l'enum
                .collect(Collectors.toList());

        // Restituisce un'istanza di User di Spring Security
        return new org.springframework.security.core.userdetails.User(
                user.getNomeUtente(),
                user.getPassword(),
                authorities // Passa le autorità ottenute
        );
    }
}
