package uz.marina.tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.marina.tables.model.User;
import uz.marina.tables.service.UserService;

import java.util.List;


/**
 * Created by Vladimir on 07.03.2017.
 */

@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(@RequestParam(value="page", required = false) Long page, Model model){
        if (null==page)
            page=1L;
        model.addAttribute("user", new User());
        model.addAttribute("listUsers",this.userService.listUsers(page));
        model.addAttribute("page", page);
        return "users";
    }

   @RequestMapping(value="searchresults", method = RequestMethod.POST)
   public String searchResults(@ModelAttribute("user") User user, Model model) {
       model.addAttribute("user", new User());
       List<User> searchResult  = this.userService.listUsersByName(user.getName());
       model.addAttribute("listUsers", searchResult);
       return "searchresults";
   }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if (user.getId()==0){
            this.userService.addUser(user);}
        else{
            this.userService.updateUser(user);}
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@RequestParam(value="page", required = false) Long page,@PathVariable("id") int id, Model model){
        if (null==page)
            page=1L;
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers",this.userService.listUsers(page));
        model.addAttribute("page",page);
        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        return "userdata";
    }


}
