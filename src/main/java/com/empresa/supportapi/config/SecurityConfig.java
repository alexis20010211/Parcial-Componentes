package com.empresa.supportapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Habilita @PreAuthorize
public class SecurityConfig {

    // === Usuarios en memoria con roles ===
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

    // === Codificador de contraseñas ===
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // === Configuración de seguridad HTTP y control de roles ===
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Deshabilitar CSRF para pruebas con Swagger/Postman
            .csrf(csrf -> csrf.disable())

            // Definir acceso a endpoints según rol
            .authorizeHttpRequests(auth -> auth
                // Endpoints públicos de registro y login
                .requestMatchers("/api/auth/register/cliente", "/api/auth/login").permitAll()

                // Endpoint de registro de técnicos solo ADMIN
                .requestMatchers("/api/auth/register/tecnico").hasRole("ADMIN")

                // Clientes
                .requestMatchers("/api/clientes/**").hasAnyRole("ADMIN", "TECNICO")

                // Técnicos
                .requestMatchers("/api/tecnico/**").hasRole("TECNICO") // perfil propio
                .requestMatchers("/api/tecnicos/**").hasRole("ADMIN")   // gestión completa por ADMIN

                // Solicitudes
                .requestMatchers("/api/solicitudes/**").hasAnyRole("ADMIN", "TECNICO", "CLIENTE")

                // Estados de solicitud
                .requestMatchers("/api/estadosolicitud/**").hasAnyRole("ADMIN", "TECNICO")

                // Admins
                .requestMatchers("/api/admins/**").hasRole("ADMIN")

                // Cualquier otro endpoint requiere autenticación
                .anyRequest().authenticated()
            )

            // Manejo personalizado de acceso denegado
            .exceptionHandling(exception -> exception
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.setStatus(403);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\": \"Tu rol no tiene acceso a este endpoint\"}");
                })
            )

            // Autenticación HTTP Basic (Swagger/Postman)
            .httpBasic(withDefaults());

        return http.build();
    }
}
