package in.kuru.JPA_CRUD.repository;

import in.kuru.JPA_CRUD.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {



}
