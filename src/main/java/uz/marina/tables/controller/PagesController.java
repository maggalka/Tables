package uz.marina.tables.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vladimir on 21.08.2017.
 */
@Controller
public class PagesController {

    @RequestMapping(value = "adminMain", method = RequestMethod.GET)
    public String showAdminPage(){
        return "adminMain";
    }

    @RequestMapping(value = "userMain", method = RequestMethod.GET)
    public String showUserPage(){
        return "userMain";
    }
}
