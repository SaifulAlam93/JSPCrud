/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;
    
    
  @RequestMapping("/add_user_form")
    public String showform(Model m) {
        m.addAttribute("command", new User());
        return "user/add_user_form";
    }

    @RequestMapping("/edit_user_form")
    public String showEditform(Model m,
            @RequestParam(value = "id", required = true) Long id
    ) {
        User user = userService.getUserById(id);
        m.addAttribute("command", user);
        return "user/edit_user_form";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addUser(ModelMap model,
            @ModelAttribute("emp") User user
    ) {
        System.out.println(user.getUserName());

        try {
            userService.addUser(user);
        } catch (Exception e) {
            model.addAttribute("failed_message", "User Add failed ! \n" + e);
            return "message";
        }

        model.addAttribute("success_message", "User Addedd successfully !");

        return "message";

    }

    @RequestMapping(value = "/delete_user")
    public String deleteUser(ModelMap model,
            @RequestParam(value = "id", required = true) Long id
    ) {

        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            model.addAttribute("failed_message", "User Deletion failed ! \n " + e);
            return "message";
        }
        model.addAttribute("success_message", "User Deleted successfully !");

        return "message";

    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.POST)
    public String editUser(ModelMap model,
            @ModelAttribute("user") User user
    ) {

        try {
            userService.editUser(user);
        } catch (Exception e) {
            model.addAttribute("failed_message", "User Edit failed !");
            return "message";
        }
        model.addAttribute("success_message", "User Edited successfully !");

        return "message";

    }

    @RequestMapping(value = "/list_user", method = RequestMethod.GET)
    public String listUsers(ModelMap model, @RequestParam(value = "pageID", required = false) Integer pageID) {

        List<User> users = userService.listUsers(pageID);
        model.addAttribute("list", users);

        return "user/list_user";
    }
}
