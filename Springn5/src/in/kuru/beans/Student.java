package in.kuru.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
    private String name;
    private int roll;
    @Autowired
    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void display(){
        System.out.println("name: "+name);
        System.out.println("roll no: "+roll);
        System.out.println("Address: "+address);

    }
}
