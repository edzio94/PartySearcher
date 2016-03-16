package mainpackage;

import mainpackage.user.UserDTO;
import mainpackage.database.UserRegisterOperations;
import mainpackage.registration.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by lukasz on 10.02.16.
 */
@Controller
public class IndexController {


    @Autowired
    UserRegisterOperations databaseTemplate;

    @Autowired
    RegistrationValidator validator;


    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public String index() {
        return "<b>Hello fdfdsfds</b>";
    }

    @RequestMapping(value = "/signup")
    @ResponseBody
    public String signUp(){
        return "<b> lipa </b> ziomus";
    }
    @RequestMapping(value = "/preauthorize")
    @ResponseBody
    public String Preauthorize()
    {
        return "<i> wqewq </i>";
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/registerAccount", method = RequestMethod.POST)
    public UserDTO registerAccount(@RequestBody UserDTO userDTO)
    {

        System.out.println("Email: "+userDTO.getEmail());
        System.out.println("if email good:"+validator.checkEmail(userDTO));
        databaseTemplate.registerUserIntoDatabase(userDTO);

        return new UserDTO();
    }

    @ResponseBody
    @RequestMapping(value = "/cookie")
    public UserDTO getCookie()
    {

        return new UserDTO();
    }


}