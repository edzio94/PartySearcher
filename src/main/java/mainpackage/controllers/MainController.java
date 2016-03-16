package mainpackage.controllers;

import org.springframework.web.bind.annotation.*;

/**
 * Created by lukasz on 11.02.16.
 */
@RestController
public class MainController {
/* DOES NOT WORK!
    @ResponseBody
    @RequestMapping(value = "/registerAccount")//, method = RequestMethod.POST)
    public String registerAccount(@RequestBody UserDTO userDTO)
    {

        System.out.println("Jedziemy z tematem");

        return "Done !"+userDTO.getEmail();
    }   */
}
