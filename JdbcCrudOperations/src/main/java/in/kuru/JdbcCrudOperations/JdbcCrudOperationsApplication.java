package in.kuru.JdbcCrudOperations;

import in.kuru.JdbcCrudOperations.dao.DaoUser;
import in.kuru.JdbcCrudOperations.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JdbcCrudOperationsApplication implements CommandLineRunner {
    @Autowired
    private DaoUser daoUser;
	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudOperationsApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
//        User user1= new User();
//        user1.setName("suru");
//        user1.setEmail("suruuu@gmail.com");
//        user1.setGender("mm");
//        user1.setCity("lkooo");

//        boolean status= daoUser.deleteUserByEmail("kuruuu@gmail.com");
//        if(status){
//            System.out.println("user deleted successfully");
//
//        }else{
//            System.out.println("failure");
//        }

//        User user = daoUser.getUserByEmail("muruuu@gmail.com");
//
//        if(user!=null){
//        System.out.println("name :"+user.getName());
//        System.out.println("email :"+user.getEmail());
//        System.out.println("gender :"+user.getGender());
//        System.out.println("city :"+user.getCity());
//        }else{
//            System.out.println("invalid details");
//        }

        List<User> users= daoUser.getAllUsers();

        users.stream().forEach(System.out::println);
    }
}
