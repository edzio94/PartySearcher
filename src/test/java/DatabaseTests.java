import mainpackage.user.UserDTO;
import mainpackage.spring.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Types;

/**
 * Created by lukasz on 11.02.16.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class DatabaseTests {

    @Autowired

    JdbcTemplate template;


    UserDTO u = new UserDTO("edzio94","ww","ww","eda@eda.com");

    private boolean mockInitialized = false;

    @Before
    public void init() {
        System.out.println("NEW TEST");
        if (!mockInitialized) {
            MockitoAnnotations.initMocks(this);
            System.out.println("DONE!!!!");
            mockInitialized = true;
        }
    }

    @Test
    public void InsertIntoDatabase() {

        Object [] params = new Object[] {u.getUserName(), u.getPassword(),u.getEmail()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        template.update("INSERT INTO users(username,password,email) VALUES(?,?,?)",params,types);


    }

    @Test
    public void validateRegistration()
    {
        UserDTO x = new UserDTO("edek","lipton","lipton","test@test.com");
     //   Assert.assertTrue(RegistrationValidator.checkEmail(x));
      //  Assert.assertTrue(RegistrationValidator.comparePasswords(x));

    }


}
