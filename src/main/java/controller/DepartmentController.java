/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.DepartmentService;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    
    

 @RequestMapping("/add_department_form")
    public String showform(Model m) {
        m.addAttribute("command", new Department());
        return "department/add_department_form";
    }

    @RequestMapping("/edit_department_form")
    public String showEditform(Model m,
            @RequestParam(value = "id", required = true) Long id
    ) {
        Department department = departmentService.getDepartmentById(id);
        m.addAttribute("command", department);
        return "department/edit_department_form";
    }

    @RequestMapping(value = "/add_department", method = RequestMethod.POST)
    public String addDepartment(ModelMap model,
            @ModelAttribute("emp") Department department
    ) {
        System.out.println(department.getDepartmentName());

        try {
            departmentService.addDepartment(department);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Department Add failed ! \n" + e);
            return "message";
        }

        model.addAttribute("success_message", "Department Addedd successfully !");

        return "message";

    }

    @RequestMapping(value = "/delete_department")
    public String deleteDepartment(ModelMap model,
            @RequestParam(value = "id", required = true) Long id
    ) {

        try {
            departmentService.deleteDepartment(id);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Department Deletion failed ! \n " + e);
            return "message";
        }
        model.addAttribute("success_message", "Department Deleted successfully !");

        return "message";

    }

    @RequestMapping(value = "/edit_department", method = RequestMethod.POST)
    public String editDepartment(ModelMap model,
            @ModelAttribute("department") Department department
    ) {

        try {
            departmentService.editDepartment(department);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Department Edit failed !");
            return "message";
        }
        model.addAttribute("success_message", "Department Edited successfully !");

        return "message";

    }

    @RequestMapping(value = "/list_department", method = RequestMethod.GET)
    public String listDepartments(ModelMap model, @RequestParam(value = "pageID", required = false) Integer pageID) {

        List<Department> departments = departmentService.listDepartments(pageID);
        model.addAttribute("list", departments);

        return "department/list_department";
    }
}
