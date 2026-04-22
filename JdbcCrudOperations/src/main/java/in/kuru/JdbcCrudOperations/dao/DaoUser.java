package in.kuru.JdbcCrudOperations.dao;


import in.kuru.JdbcCrudOperations.entity.User;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DaoUser {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertUser(User user){

        boolean status=false;

        try
        {
        String insert_query="INSERT INTO users VALUES (?,?,?,?)";
        int count = jdbcTemplate.update(insert_query, user.getName(), user.getEmail(), user.getGender(), user.getCity());

        if(count>0){
            status=true;
            System.out.println("insertion successfull");

        }
        else{
            status=false;
        }

        }catch(Exception e){
            status=false;
            e.printStackTrace();
        }

        return status;

    }

    public boolean updateUser(User user){

        boolean status=false;
        try{
        String update_query="UPDATE users SET email=?, gender=?, city=? WHERE NAME=?";
        int count= jdbcTemplate.update(update_query, user.getEmail(), user.getGender(), user.getCity(), user.getName());

            if(count>0){
                status=true;
            }else{
                status=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public boolean deleteUserByEmail(String email){

        boolean status=false;
        try{
        String delete_query="DELETE FROM users WHERE email=?";
        int count= jdbcTemplate.update(delete_query, email);

            if(count>0){
                status=true;
            }else{
                status=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public User getUserByEmail(String email){
        String select_query="SELECT * FROM users WHERE email=?";

        return jdbcTemplate.queryForObject(select_query, new UserRowMapper(), email);

    }

    public static final class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {

            User user = new User();
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setCity(rs.getString("city"));

            return user;
        }
    }

    public List<User> getAllUsers(){
        String selectAll_query= "SELECT * FROM users";

        List<User> users =jdbcTemplate.query(selectAll_query, new UserRowMapper());
        return users;
    }
}
