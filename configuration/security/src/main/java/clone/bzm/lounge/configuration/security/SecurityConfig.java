package clone.bzm.lounge.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final ObjectMapper mapper;

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web
                .ignoring()
                .requestMatchers(toH2Console());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // @formatter:off
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console())
                        .disable()
                )

                .headers(headers -> headers.frameOptions()
                        .sameOrigin()
                )

                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/v1/user/sign-up").permitAll()
                        .requestMatchers("/api/v1/user/sign-in").permitAll()
                        .requestMatchers("/api/v1/user/sign-in-qr").permitAll()
                        .requestMatchers("/api/example").permitAll()
                        .anyRequest()
                        .authenticated()
                )

                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler)
                )

                .sessionManagement(session -> session
                        .sessionCreationPolicy(STATELESS)
                )

                .logout(logout -> logout
                        .logoutUrl("/api/v1/user/sign-out")
                        .addLogoutHandler((request, response, authentication) -> {
                            System.out.println("#####: logout... " + authentication);
                        })
                        .logoutSuccessHandler((request, response, authentication) -> {
                            System.out.println("#####: logout... " + authentication);
                            SecurityContextHolder.clearContext();
                        })
                )

                .apply(new JwtSecurityConfig(mapper))
        ;

        // @formatter:on

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
