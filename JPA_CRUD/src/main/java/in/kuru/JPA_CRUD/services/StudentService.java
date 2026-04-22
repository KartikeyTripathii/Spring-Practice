package in.kuru.JPA_CRUD.services;

import in.kuru.JPA_CRUD.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    boolean addStudtntDetails(Student std);
    List<Student> getAllStudents();
    Student getStdById(Long id);

    Student updateStdMarks(Long id, float marks);
}
