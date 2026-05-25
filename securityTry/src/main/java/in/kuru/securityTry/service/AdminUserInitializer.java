package in.kuru.securityTry.service;

import in.kuru.securityTry.entities.Users;
import in.kuru.securityTry.repository.UserDetailRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer
{
    @Bean
    public CommandLineRunner createAdminUser(UserDetailRepository userDetailRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(userDetailRepository.findByUsername("admin").isEmpty()){
                Users admin= new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("123"));
                admin.setRole("ROLE_ADMIN");

                userDetailRepository.save(admin);
                System.out.println("admin user created");
            }
        };
    }
}
