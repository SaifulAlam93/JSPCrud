/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.impl.DepartmentRepository;
import java.util.List;
import model.Department;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public boolean addDepartment(Department department) throws Exception {

        boolean success = false;

        boolean departmentAlreadyExists = checkIfDepartmentAlreadyExists(department.getDepartmentName());

        if (departmentAlreadyExists) {

            throw new Exception(" Department  : " + department.getDepartmentName() + " already exists !");
        }

        success = departmentRepository.insertDepartmentInToDB(department);

        return success;
    }

    public boolean editDepartment(Department department) throws Exception {
        boolean success = false;
        Department department_old;
        department_old = departmentRepository.getDepartmentByIdFromDB(department.getId());
        if (!department_old.getDepartmentName().equals(department.getDepartmentName())) {
            throw new Exception("Suspicious activity detected, Department cann't be updated !");
        }
        success = departmentRepository.updateDepartmentInDB(department);

        return success;
    }

    public Department getDepartmentById(Long id) throws NullPointerException {

        if (id == null) {

            throw new NullPointerException("Department Id null not allowed!");
        }

        return departmentRepository.getDepartmentByIdFromDB(id);
    }

    public boolean deleteDepartment(Long id) throws Exception {
        boolean success = false;

        Department department_old;

        department_old = departmentRepository.getDepartmentByIdFromDB(id);

        if (department_old == null) {
            throw new Exception("Department  not found !");

        } else {
            success = departmentRepository.removeDepartmentFromDB(department_old);
        }
        return success;

    }

    public List<Department> listDepartments(Integer pageID) {
        if (pageID == null) {
            pageID = 0;
        }

        List<Department> departments = departmentRepository.getAllDepartmentFromDB(pageID);

        return departments;

    }

//    public List<Department> searchDepartments(String searchParameter) {
//
//        List<Department> departments = departmentRepository.getDepartmentsByNameFromDB(searchParameter);
//
////        System.out.println("==== result =====");
////
////        for (Department department : departments) {
////
////            System.out.println("department id : " + department.getDepartmentId());
////            System.out.println("department name : " + department.getName());
////            System.out.println("department address : " + department.getAddress());
////            System.out.println("department salary : " + department.getSalary());
////            System.out.println("===================================");
////
////        }
//        return departments;
//    }
//    public double totalSalary() {
//
//        double totalSalary = departmentRepository.countTotalSalaryFromDB();
//
//        return totalSalary;
//
//    }
    private boolean checkIfDepartmentAlreadyExists(String departmentId) {

        boolean departmentAlreadyExists = false;

        Department department = null;

        department = departmentRepository.getDepartmentByDepartmentNameFromDB(departmentId);

        if (department != null) {

            departmentAlreadyExists = true;
        }

        return departmentAlreadyExists;
    }

}
