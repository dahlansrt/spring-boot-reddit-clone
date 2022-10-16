package id.faroga.redditclone.controller;

import id.faroga.redditclone.dto.AuthResponse;
import id.faroga.redditclone.dto.LoginRequest;
import id.faroga.redditclone.dto.RegisterRequest;
import id.faroga.redditclone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User registration successful",
                HttpStatus.OK);
    }
    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account activated successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
       return authService.login(loginRequest);
    }
}
