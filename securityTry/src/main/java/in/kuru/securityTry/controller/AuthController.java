package in.kuru.securityTry.controller;

import in.kuru.securityTry.entities.AuthRequest;
import in.kuru.securityTry.util.JWTUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
    @Autowired
    private JWTUtilities jwtUtilities;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            return jwtUtilities.generateToken(authRequest.getUsername());
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
    }
}
