package in.kuru.securityTry.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtilities
{
    private final String SECRET="kuru ki key ye vali isko 32 bytes kaa bnao yr kuch krke";
    private final SecretKey key= Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    private final long EXPIRATION_TIME= 1000*60*60;

    public String generateToken(String username)
    {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

    public String extractUsername(String token){
        return extractClaim(token).getSubject();
    }

    private Claims extractClaim(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String username, UserDetails userDetails, String token)
    {//TODO check 1st if username is same as in user details

        //TODO check if token is not expired
        return  username.equals(userDetails.getUsername())&& !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return  extractClaim(token).getExpiration().before(new Date());
    }
}
