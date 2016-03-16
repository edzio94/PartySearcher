package mainpackage.database;

import mainpackage.user.UserDTO;
import mainpackage.user.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.Types;

/**
 * Created by lukasz on 15.02.16.
 */
@Repository
public class UserRegisterOperations implements UserRegister {

    @Autowired
    JdbcTemplate template;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void registerUserIntoDatabase(UserDTO u) {

        System.out.println("Encoded: "+passwordEncoder.encode(u.getPassword()));
        System.out.println("UserName: "+u.getUserName()+" |||");

        Object [] params = new Object[] {u.getUserName(), passwordEncoder.encode(u.getPassword()),u.getEmail()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        template.update(INSERT_USER_INTO_TABLE,params, types);
        params = new Object[] {u.getUserName(),"USER"};
        types = new int[] {Types.VARCHAR,Types.VARCHAR};
        template.update(INSERT_ROLE_INTO_TABLE,params,types);
        System.out.println("ENd of adding");
    }
}
