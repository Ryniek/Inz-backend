package pl.rynski.inzynierkabackend.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String email;
    private List<String> roles = new ArrayList<>();
}
