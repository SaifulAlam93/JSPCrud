/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.List;
import model.Employee;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // =================== DB ===================
    public Employee getEmployeeByEmployeeIdFromDB(String employeeId) {

        String sql = "Select a from Employee a where a.employeeId=:employeeId ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("employeeId", employeeId);
        if (query.list().size() > 0) {
            return (Employee) query.list().get(0);
        }
        return null;
    }

    public Employee getEmployeeByIdFromDB(Long id) {

        String sql = "Select a from Employee a where a.id=:id ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("id", id);
        if (query.list().size() > 0) {
            return (Employee) query.list().get(0);
        }
        return null;
    }

    public boolean insertEmployeeInToDB(Employee employee) {

        sessionFactory.getCurrentSession().save(employee);

        return true;
    }

    public boolean updateEmployeeInDB(Employee employee) {

        sessionFactory.getCurrentSession().update(employee);

        return true;

    }

    public boolean removeEmployeeFromDB(Employee employee) {
        sessionFactory.getCurrentSession().remove(employee);

        return true;

    }

    public List<Employee> getAllEmployeeFromDB(Integer pageID) {

        String sql = "Select a from Employee a ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);

        query.setFirstResult(pageID);
        query.setMaxResults(10);

        return query.list();
    }

//    public List<Employee> getEmployeesByNameFromDB(String name) {
//
//        List<Employee> employees = new ArrayList<>();
//        return employees;
//    }
//
//    public double countTotalSalaryFromDB() {
//        double totalSalary = 0.0;
//        return totalSalary;
//    }
}
