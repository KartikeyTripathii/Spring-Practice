package in.kuru.main.repositories;

import in.kuru.main.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer>
{
    User findByEmail(String email);
}
