package in.kuruweb.sbProject1.beans;

public class Student {
    private String name;
    private int rollNo;
    private float mark;

    public Student(String name, int rollNo, float mark) {
        this.name = name;
        this.rollNo = rollNo;
        this.mark = mark;
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

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void displayStdDetails(){
        System.out.println("Name "+name);
        System.out.println("Roll number "+rollNo);
        System.out.println("Marks obtained "+mark);
    }
}
