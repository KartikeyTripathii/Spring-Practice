package in.kuru.JPA_CRUD.services;

import in.kuru.JPA_CRUD.entities.Student;
import in.kuru.JPA_CRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public boolean addStudtntDetails(Student std) {
        boolean status=false;
        try{
            studentRepository.save(std);
            status=true;

        } catch (Exception e) {
            e.printStackTrace();
            status=false;
        }
        return status;
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStdById(Long id)
    {
        Optional<Student> std= studentRepository.findById(id);
        if(std.isPresent()){
            return std.get();

        }
        else{
            return null;
        }
    }

}

