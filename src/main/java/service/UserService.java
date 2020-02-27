/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import dao.impl.UserRepository;
import java.util.List;
import model.User;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByIdAndPasswordFromDB(String userId) {

        User user = userRepository.getUserByUserIdFromDB(userId);

        return user;
    }

    
   public boolean addUser(User employee) throws Exception {

        boolean success = false;

        boolean employeeAlreadyExists = checkIfUserAlreadyExists(employee.getUserId());

        if (employeeAlreadyExists) {

            throw new Exception(" User Id : " + employee.getUserId() + " already exists !");
        }

        success = userRepository.insertUserInToDB(employee);

        return success;
    }

    public boolean editUser(User employee) throws Exception {
        boolean success = false;
        User employee_old;
        employee_old = userRepository.getUserByIdFromDB(employee.getId());
        if (!employee_old.getUserId().equals(employee.getUserId())) {
            throw new Exception("Suspicious activity detected, User cann't be updated !");
        }
        success = userRepository.updateUserInDB(employee);

        return success;
    }

    public User getUserById(Long id) throws NullPointerException {

        if (id == null) {

            throw new NullPointerException("User Id null not allowed!");
        }

        return userRepository.getUserByIdFromDB(id);
    }

    public boolean deleteUser(Long id) throws Exception {
        boolean success = false;

        User employee_old;

        employee_old = userRepository.getUserByIdFromDB(id);

        if (employee_old == null) {
            throw new Exception("User  not found !");

        } else {
            success = userRepository.removeUserFromDB(employee_old);
        }
        return success;

    }

    public List<User> listUsers(Integer pageID) {
        if (pageID == null) {
            pageID = 0;
        }

        List<User> employees = userRepository.getAllUserFromDB(pageID);

        return employees;

    }

//    public List<User> searchUsers(String searchParameter) {
//
//        List<User> employees = userRepository.getUsersByNameFromDB(searchParameter);
//
////        System.out.println("==== result =====");
////
////        for (User employee : employees) {
////
////            System.out.println("employee id : " + employee.getUserId());
////            System.out.println("employee name : " + employee.getName());
////            System.out.println("employee address : " + employee.getAddress());
////            System.out.println("employee salary : " + employee.getSalary());
////            System.out.println("===================================");
////
////        }
//        return employees;
//    }
//    public double totalSalary() {
//
//        double totalSalary = userRepository.countTotalSalaryFromDB();
//
//        return totalSalary;
//
//    }
    private boolean checkIfUserAlreadyExists(String employeeId) {

        boolean employeeAlreadyExists = false;

        User employee = null;

        employee = userRepository.getUserByUserIdFromDB(employeeId);

        if (employee != null) {

            employeeAlreadyExists = true;
        }

        return employeeAlreadyExists;
    }

    
}
