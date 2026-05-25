package in.kuru.securityTry.repository;

import in.kuru.securityTry.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
