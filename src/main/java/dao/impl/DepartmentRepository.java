/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.List;
import model.Department;
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
public class DepartmentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // =================== DB ===================
    public Department getDepartmentByDepartmentNameFromDB(String departmentId) {

        String sql = "Select a from Department a where a.departmentName=:departmentName ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("departmentName", departmentId);
        if (query.list().size() > 0) {
            return (Department) query.list().get(0);
        }
        return null;
    }

    public Department getDepartmentByIdFromDB(Long id) {

        String sql = "Select a from Department a where a.id=:id ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("id", id);
        if (query.list().size() > 0) {
            return (Department) query.list().get(0);
        }
        return null;
    }

    public boolean insertDepartmentInToDB(Department department) {

        sessionFactory.getCurrentSession().save(department);

        return true;
    }

    public boolean updateDepartmentInDB(Department department) {

        sessionFactory.getCurrentSession().update(department);

        return true;

    }

    public boolean removeDepartmentFromDB(Department department) {
        sessionFactory.getCurrentSession().remove(department);

        return true;

    }

    public List<Department> getAllDepartmentFromDB(Integer pageID) {

        String sql = "Select a from Department a ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);

        query.setFirstResult(pageID);
        query.setMaxResults(10);

        return query.list();
    }

//    public List<Department> getDepartmentsByNameFromDB(String name) {
//
//        List<Department> departments = new ArrayList<>();
//        return departments;
//    }
//
//    public double countTotalSalaryFromDB() {
//        double totalSalary = 0.0;
//        return totalSalary;
//    }
}
