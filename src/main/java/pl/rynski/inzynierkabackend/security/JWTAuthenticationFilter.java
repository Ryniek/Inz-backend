package pl.rynski.inzynierkabackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.rynski.inzynierkabackend.dao.model.User;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    //TODO wstrzyknac
    private String jwtSecret = "test123";
    private Long jwtValidity = 100000000L;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            User creds = new ObjectMapper()
                    .readValue(req.getInputStream(), User.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {

        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withClaim("role", principal.getAuthorities().iterator().next().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtValidity))
                .sign(Algorithm.HMAC512(jwtSecret.getBytes()));
        JwtResponse response = new JwtResponse(token, principal.getUsername(), principal.getAuthorities().stream().map(Object::toString).collect(Collectors.toList()));
        res.setContentType("application/json");
        res.getWriter().write(new ObjectMapper().writeValueAsString(response));
        res.getWriter().flush();
    }
}
