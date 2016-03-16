package mainpackage.user;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by lukasz on 11.02.16.
 */
public class UserDTO {

    @NotEmpty
    private String userName;


    @NotEmpty
    private String password;

    @NotEmpty
    private String matchingPassword;

    @NotEmpty
    private String email;

    public UserDTO(String userName, String password, String matchingPassword
    , String email)
    {
        this.userName = userName;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }
    public UserDTO(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassowrd() {
        return matchingPassword;
    }

    public void setMatchingPassowrd(String matchingPassowrd) {
        this.matchingPassword = matchingPassowrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
