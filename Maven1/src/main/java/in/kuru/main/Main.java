package in.kuru.main;

import in.kuru.beans.Student;
import in.kuru.mapper.StudentRowMapper;
import in.kuru.resources.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);

//    -----------INSERTION QUERY--------------
//        String name="suru";
//        int roll= 13;
//        int marks=49;
//        int count=0;
//        String insert_sql_query= "INSERT INTO Student Values(?,?,?)";
//
//        count = jdbc.update(insert_sql_query, roll,name,marks);
//
//        if(count>0){
//            System.out.println("values inserted");
//        }
//        else{
//            System.out.println("value not inserted");
//        }
//      ------------UPDATION QUERY-------------

//        String name="kuru";
//        int roll= 13;
//        int marks=45;
//        int count=0;
//
//        String update_sql_query="UPDATE STUDENT set std_marks=? where std_roll=?";
//
//        count= jdbc.update(update_sql_query,marks, roll);
//
//        if(count>0){
//            System.out.println("updation success");
//        }
//        else{
//            System.out.println("updation failed");
//        }
//        ------------SELECTION QUERY-------------

        String select_sql_query="select * from student";
        List<Student> stdList=  jdbc.query(select_sql_query,new StudentRowMapper());
        for(Student std : stdList){
            System.out.println("roll no: "+ std.getRoll());
            System.out.println("name: "+ std.getName());
            System.out.println("marks: "+ std.getMarks());
            System.out.println("============================");
        }

    }
}
