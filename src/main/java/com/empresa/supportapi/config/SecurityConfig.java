package com.empresa.supportapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class SecurityConfig {

    // Crear usuarios en memoria con roles
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails tecnico = User.withUsername("tecnico")
                .password(encoder.encode("tec123"))
                .roles("TECNICO")
                .build();

        UserDetails cliente = User.withUsername("cliente")
                .password(encoder.encode("cli123"))
                .roles("CLIENTE")
                .build();

        return new InMemoryUserDetailsManager(admin, tecnico, cliente);
    }

    // Definir codificador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configurar seguridad HTTP y control de acceso a endpoints
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // ADMIN y TECNICO pueden acceder a clientes
                .requestMatchers("/api/clientes/**").hasAnyRole("ADMIN", "TECNICO")
                // ADMIN puede acceder a técnicos
                .requestMatchers("/api/tecnicos/**").hasRole("ADMIN")
                // ADMIN, TECNICO y CLIENTE pueden acceder a solicitudes
                .requestMatchers("/api/solicitudes/**").hasAnyRole("ADMIN", "TECNICO", "CLIENTE")
                // ADMIN y TECNICO pueden cambiar estados de solicitudes
                .requestMatchers("/api/estadosolicitud/**").hasAnyRole("ADMIN", "TECNICO")
                // Cualquier otro endpoint requiere autenticación
                .anyRequest().authenticated()
            )
            .httpBasic(); // autenticación básica
        return http.build();
    }
}
