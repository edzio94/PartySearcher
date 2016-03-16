package mainpackage.user;

import mainpackage.AppInit;

/**
 * Created by lukasz on 15.02.16.
 */
public interface UserRegister {
    String INSERT_USER_INTO_TABLE="INSERT INTO users(username,password,email) VALUES(?,?,?)";

    String INSERT_ROLE_INTO_TABLE="INSERT INTO users_roles(username,role) VALUES (?,?) ";

    void registerUserIntoDatabase(UserDTO u);
}
