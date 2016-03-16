package mainpackage.registration;

import mainpackage.user.UserDTO;
import org.springframework.stereotype.Service;

/**
 * Created by lukasz on 09.02.16.
 */

@Service
public class RegistrationValidator {


    public  boolean comparePasswords(UserDTO u)
    {
        return u.getPassword().equals(u.getMatchingPassowrd());
    }

    public  boolean checkEmail(UserDTO u)
    {
        return u.getEmail().matches(".*@.*\\.*");
    }
}
