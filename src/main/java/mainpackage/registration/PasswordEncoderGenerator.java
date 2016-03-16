package mainpackage.registration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by lukasz on 12.02.16.
 */
@Component
public class PasswordEncoderGenerator {

    public BCryptPasswordEncoder passwordEncoder;

    public PasswordEncoderGenerator()
    {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encodePassword(String password)
    {
        return passwordEncoder.encode(password);
    }

}
