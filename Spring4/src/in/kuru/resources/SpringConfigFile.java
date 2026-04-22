package in.kuru.resources;

import in.kuru.beans.Address;
import in.kuru.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class SpringConfigFile {

    @Bean
    public Address createAddrbj(){
        Address address= new Address();
        address.setLane(11);
        address.setCity("Lko");
        address.setPin(123454);

        return address;
    }

    @Bean("std1")
    public Student createStdObj(){
        Student student=new Student();
        student.setRoll(1);
        student.setName("kuru");
        student.setAddress(createAddrbj());

        return student;
    }
}
