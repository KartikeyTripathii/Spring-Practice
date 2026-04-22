package in.kuruweb.sbProject1.config;

import in.kuruweb.sbProject1.beans.Student;
import in.kuruweb.sbProject1.main.MyClass;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config  {

    @Bean
    public CommandLineRunner commandLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                student().displayStdDetails();
                System.out.println("=====================================");
                myClass().printMessage("kuru");
            }
        };
    }

    @Bean
    public Student student(){
        return new Student("kuru", 12, 99.99f);
    }

    @Bean
    public MyClass myClass(){
        return new MyClass();
    }
}
