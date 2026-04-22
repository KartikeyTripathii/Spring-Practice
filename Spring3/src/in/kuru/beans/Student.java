package in.kuru.beans;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("kuru")
    private String name;
    @Value("001")
    private int roll;
    @Value("kuru@gmail.com")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display(){
        System.out.println("name: "+name);
        System.out.println("roll no: "+ roll);
        System.out.println("email: "+email);
    }
}
