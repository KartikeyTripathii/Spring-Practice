package in.kuru.JdbcCrudOperations.entity;

public class User {
    private String name;
    private String email;
    private  String gender;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String  toString() {
        System.out.println("name :"+this.getName());
        System.out.println("email :"+this.getEmail());
        System.out.println("gender :"+this.getGender());
        System.out.println("city :"+this.getCity());
        System.out.println("=================================");
        return "";
    }
}
