/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.impl.EmployeeRepository;
import java.util.List;
import model.Employee;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public boolean addEmployee(Employee employee) throws Exception {

        boolean success = false;

        boolean employeeAlreadyExists = checkIfEmployeeAlreadyExists(employee.getEmployeeId());

        if (employeeAlreadyExists) {

            throw new Exception(" Employee Id : " + employee.getEmployeeId() + " already exists !");
        }

        success = employeeRepository.insertEmployeeInToDB(employee);

        return success;
    }

    public boolean editEmployee(Employee employee) throws Exception {
        boolean success = false;
        Employee employee_old;
        employee_old = employeeRepository.getEmployeeByIdFromDB(employee.getId());
        if (!employee_old.getEmployeeId().equals(employee.getEmployeeId())) {
            throw new Exception("Suspicious activity detected, Employee cann't be updated !");
        }
        success = employeeRepository.updateEmployeeInDB(employee);

        return success;
    }

    public Employee getEmployeeById(Long id) throws NullPointerException {

        if (id == null) {

            throw new NullPointerException("Employee Id null not allowed!");
        }

        return employeeRepository.getEmployeeByIdFromDB(id);
    }

    public boolean deleteEmployee(Long id) throws Exception {
        boolean success = false;

        Employee employee_old;

        employee_old = employeeRepository.getEmployeeByIdFromDB(id);

        if (employee_old == null) {
            throw new Exception("Employee  not found !");

        } else {
            success = employeeRepository.removeEmployeeFromDB(employee_old);
        }
        return success;

    }

    public List<Employee> listEmployees(Integer pageID) {
        if (pageID == null) {
            pageID = 0;
        }

        List<Employee> employees = employeeRepository.getAllEmployeeFromDB(pageID);

        return employees;

    }

//    public List<Employee> searchEmployees(String searchParameter) {
//
//        List<Employee> employees = employeeRepository.getEmployeesByNameFromDB(searchParameter);
//
////        System.out.println("==== result =====");
////
////        for (Employee employee : employees) {
////
////            System.out.println("employee id : " + employee.getEmployeeId());
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
//        double totalSalary = employeeRepository.countTotalSalaryFromDB();
//
//        return totalSalary;
//
//    }
    private boolean checkIfEmployeeAlreadyExists(String employeeId) {

        boolean employeeAlreadyExists = false;

        Employee employee = null;

        employee = employeeRepository.getEmployeeByEmployeeIdFromDB(employeeId);

        if (employee != null) {

            employeeAlreadyExists = true;
        }

        return employeeAlreadyExists;
    }

}
