package com.my_app.my_app.security.sessioniwithJWT.Controllers;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my_app.my_app.dbrel.JPA.Entity.Users;
import com.my_app.my_app.dbrel.JPA.Repository.Inizializzazione.UsersS;
import com.my_app.my_app.security.sessioniwithJWT.JWT.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersS usersS;

    @Autowired
    private JwtUtil jwtUtil; // Aggiungi JwtUtil per gestire la generazione dei token

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Cripta la password
        usersS.save(user); // Salva l'utente nel database
        return ResponseEntity.status(HttpStatus.SC_CREATED).body("Utente registrato!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            // Autentica l'utente
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            // Carica i dettagli dell'utente
            UserDetails userDetails = (UserDetails) auth.getPrincipal();

            // Genera il token JWT
            String jwt = jwtUtil.generateToken(userDetails);

            // Restituisce il token JWT al client
            return ResponseEntity.ok("Token JWT: " + jwt);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body("Credenziali non valide");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            return ResponseEntity.ok("Logout avvenuto con successo.");
        } else {
            return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body("Non sei autenticato.");
        }
    }
}
