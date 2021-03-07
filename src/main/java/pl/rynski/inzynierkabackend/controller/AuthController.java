package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.request.UserDto;
import pl.rynski.inzynierkabackend.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Login and get token with user info in response")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Registration")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        authService.register(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Endpoint created due to test jwt")
    @GetMapping("/token/test")
    public ResponseEntity<?> tokenTest() {
        return ResponseEntity.ok("Secured");
    }
}
