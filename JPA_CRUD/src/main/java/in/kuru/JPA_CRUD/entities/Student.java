package in.kuru.JPA_CRUD.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private  long id;
    @Column
    private String name;
    @Column
    private int rollNo;
    @Column
    private float marks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {

        System.out.println(this.getName());
        System.out.println(this.getRollNo());
        System.out.println(this.getMarks());

        return "-------------------------------";
    }
}
