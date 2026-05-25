package in.kuru.securityTry.filter;

import in.kuru.securityTry.service.CustomUserDetailService;
import in.kuru.securityTry.util.JWTUtilities;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JWTUtilities jwtUtilities;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader= request.getHeader("Authorization");
        String token=null;
        String username=null;
        if (authHeader!=null && authHeader.startsWith("Bearer ")){
            token=authHeader.substring(7);
            username= jwtUtilities.extractUsername(token);
        }
        //TODO validate the token
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            //TODO fetch user by username
            UserDetails userDetails= customUserDetailService.loadUserByUsername(username);
            if (jwtUtilities.validateToken(username, userDetails, token)){
                UsernamePasswordAuthenticationToken userAuthToken= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                userAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userAuthToken);
            }
        }
        //TODO save to spring context

        filterChain.doFilter(request, response);
    }


}
