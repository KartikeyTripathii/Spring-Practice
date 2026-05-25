package in.kuru.JPA_CRUD;

import in.kuru.JPA_CRUD.entities.Student;
import in.kuru.JPA_CRUD.services.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaCrudApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(JpaCrudApplication.class, args);

        StudentServiceImpl service=  context.getBean(StudentServiceImpl.class);


        //Insert operation----------------------------
//        Student std= new Student();
//        std.setName("suru");
//        std.setRollNo(39);
//        std.setMarks(69f);

//        boolean status= service.addStudtntDetails(std);

//        if(status){
//            System.out.println("Student data inserted successfully");
//        }else{
//            System.out.println("some error occurred");
//        }
    // get all students-------------------------
//        List<Student> students= service.getAllStudents();
//        students.stream().forEach(System.out::println);

        //get student by id----------------------------------

//        Long id= 2L;
//
//        Student std= service.getStdById(id);
//
//        System.out.println(std);

        //update student's marks by id






	}

}
