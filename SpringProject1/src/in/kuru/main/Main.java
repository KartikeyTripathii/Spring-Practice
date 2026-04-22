package in.kuru.main;

import in.kuru.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String configFilePath="/in/kuru/resources/applicationContext.xml";
        ApplicationContext context= new ClassPathXmlApplicationContext(configFilePath);
        Student std = (Student) context.getBean("stdId");
        std.display();


    }
}
