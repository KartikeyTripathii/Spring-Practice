package in.kuru.securityTry.service;

import in.kuru.securityTry.entities.Users;
import in.kuru.securityTry.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService
{
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<Users> checkUser=userDetailRepository.findByUsername(username);
        if (checkUser.isPresent()){
            Users user = checkUser.get();
            return user;
        }else {
            throw new RuntimeException("no such user present");
        }
    }

}
