package com.sample.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.mvc.model.EmployeeCommand;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	public void addEmployee(EmployeeCommand employee) {
		 this.sessionFactory.getCurrentSession().save(employee);
	}

	public void deleteEmployee(Integer employeeId) {
		EmployeeCommand employee = (EmployeeCommand) sessionFactory.getCurrentSession().load(EmployeeCommand.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
	}
	
	public List<EmployeeCommand> listContact() {
		  return sessionFactory.getCurrentSession().createQuery("from EmployeeCommand").list();
	}

	public EmployeeCommand getEmployeebyId(Integer employeeId) {
		EmployeeCommand empCmd = (EmployeeCommand) this.sessionFactory.getCurrentSession().get(EmployeeCommand.class, employeeId);
		return empCmd;
	}

	public void updateEmployee(EmployeeCommand employeeCommand) {
		this.sessionFactory.getCurrentSession().update(employeeCommand);
	}

	

}
