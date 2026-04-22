package in.kuru.main;

import in.kuru.beans.Student;
import in.kuru.resources.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(SpringConfigFile.class);
        Student std1 =(Student) context.getBean("newName");
        std1.display();

    }
}
