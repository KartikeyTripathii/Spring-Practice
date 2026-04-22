package in.kuru.resources;

import in.kuru.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigFile {
    @Bean ("newName")
    public Student createStdBean(){
        Student std = new Student();
        std.setName("kuru");
        std.setRoll(1);
        std.setEmail("kuru@gmail.com");
        return std;
    }
}
