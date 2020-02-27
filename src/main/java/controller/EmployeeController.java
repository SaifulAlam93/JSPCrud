/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.EmployeeService;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    @RequestMapping(value="/logout", method=RequestMethod.GET)  
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
//        if (auth != null){      
//           new SecurityContextLogoutHandler().logout(request, response, auth);  
//        }  
//         return "redirect:/";  
//     }  
//    
//       @RequestMapping(value="/login", method=RequestMethod.GET)    
//    public String login() {    
//            
//        return "login";    
//    } 
    @RequestMapping("/add_employee_form")
    public String showform(Model m) {
        m.addAttribute("command", new Employee());
        return "employee/add_employee_form";
    }

    @RequestMapping("/edit_employee_form")
    public String showEditform(Model m,
            @RequestParam(value = "id", required = true) Long id
    ) {
        Employee employee = employeeService.getEmployeeById(id);
        m.addAttribute("command", employee);
        return "employee/edit_employee_form";
    }

    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public String addEmployee(ModelMap model,
            @ModelAttribute("emp") Employee employee
    ) {
        System.out.println(employee.getEmployeeName());

        try {
            employeeService.addEmployee(employee);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Employee Add failed ! \n" + e);
            return "message";
        }

        model.addAttribute("success_message", "Employee Addedd successfully !");

        return "message";

    }

    @RequestMapping(value = "/delete_employee")
    public String deleteEmployee(ModelMap model,
            @RequestParam(value = "id", required = true) Long id
    ) {

        try {
            employeeService.deleteEmployee(id);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Employee Deletion failed ! \n " + e);
            return "message";
        }
        model.addAttribute("success_message", "Employee Deleted successfully !");

        return "message";

    }

    @RequestMapping(value = "/edit_employee", method = RequestMethod.POST)
    public String editEmployee(ModelMap model,
            @ModelAttribute("employee") Employee employee
    ) {

        try {
            employeeService.editEmployee(employee);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Employee Edit failed !");
            return "message";
        }
        model.addAttribute("success_message", "Employee Edited successfully !");

        return "message";

    }

    @RequestMapping(value = "/list_employees", method = RequestMethod.GET)
    public String listEmployees(ModelMap model, @RequestParam(value = "pageID", required = false) Integer pageID) {

        List<Employee> employees = employeeService.listEmployees(pageID);
        model.addAttribute("list", employees);

        return "employee/list_employee";
    }

//    public void searchEmployees(Scanner scanner) {
//
//        String searchParameter = getEmployeeNameFromScanner(scanner);
//
//        List<Employee> employees = getEmployeesByNameFromDB(searchParameter);
//
//        System.out.println("==== result =====");
//
//        for (Employee employee : employees) {
//
//            System.out.println("employee id : " + employee.getEmployeeId());
//            System.out.println("employee name : " + employee.getName());
//            System.out.println("employee address : " + employee.getAddress());
//            System.out.println("employee salary : " + employee.getSalary());
//            System.out.println("===================================");
//
//        }
//
//    }
//
//    public void totalSalary(Scanner scanner) {
//
//        double totalSalary = countTotalSalaryFromDB();
//
//        System.out.println("============ resulst ================");
//
//        System.out.println("total salary is : " + totalSalary);
//
//        System.out.println("==========================================");
//
//    }
}
