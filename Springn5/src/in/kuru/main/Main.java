package in.kuru.main;

import in.kuru.beans.Student;
import in.kuru.resources.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        String Config_path="/in/kuru/resources/ApplicationContext.xml";
        ApplicationContext context= new AnnotationConfigApplicationContext(SpringConfigFile.class);
        Student std =(Student) context.getBean("std1");
        std.display();
    }
}
