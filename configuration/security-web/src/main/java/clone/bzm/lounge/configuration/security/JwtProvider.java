package clone.bzm.lounge.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JwtProvider {

    private static final String SECRET_KEY = "c_l_o_n_e/b_z_m/s_e_c_r_e_t/k_e_y";

    public static String generateToken(Long id, String email, String name, String status) {
        return generateToken(id, email, name, status, null);
    }

    public static String generateToken(Long id, String email, String name, String status, String audience) {
        Map<String, Object> credential = Map.of(
                "id", id,
                "email", email,
                "name", name,
                "status", status
        );

        return Jwts.builder()
                .setIssuedAt(new Date())
                .setAudience(audience)
                .addClaims(credential)
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(UTF_8)))
                .compact();
    }

    public static BzmUserAuthentication getCredential(String jwt, ObjectMapper mapper) {
        Object claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(UTF_8)))
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        return mapper.convertValue(claims, BzmUserAuthentication.class);
    }

    public static void isValid(String jwt) {
        Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(UTF_8)))
                .build()
                .parseClaimsJws(jwt);
    }
}