package clone.bzm.lounge.configration.security;

import clone.bzm.lounge.configration.exception.BzmAuthenticationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private ObjectMapper mapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String bearerJwt = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.isBlank(bearerJwt)) {
            throw new BzmAuthenticationException("can not be blank jwt.");
        }

        String jwt = null;
        if (bearerJwt.startsWith("Bearer ")) {
            jwt = bearerJwt.substring(7);
        }

        BzmUserAuthentication credential = JwtProvider.getCredential(jwt, mapper);
        BzmUserDetails userDetails = new BzmUserDetails(credential);

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication = this.jwtAuthentication(userDetails);
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        chain.doFilter(request, response);
    }

    private Authentication jwtAuthentication(BzmUserDetails userDetails,
                                             Object credentials, Collection<? extends GrantedAuthority> authorities) {
        return new UsernamePasswordAuthenticationToken(userDetails, credentials, authorities);
    }

    private Authentication jwtAuthentication(BzmUserDetails userDetails, Object credentials) {
        return jwtAuthentication(userDetails, credentials, Collections.emptySet());
    }

    private Authentication jwtAuthentication(BzmUserDetails userDetails) {
        return jwtAuthentication(userDetails, "");
    }
}