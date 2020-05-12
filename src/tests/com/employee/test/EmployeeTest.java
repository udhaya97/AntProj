
package com.employee.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextBootstrapper;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AbstractTestContextBootstrapper;
import org.springframework.test.context.support.DefaultTestContextBootstrapper;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;

import com.employee.dao.EmployeeMapper;
import com.employee.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = { EmployeeMapper.class })

@TestExecutionListeners(listeners = {ServletTestExecutionListener.class,DirtiesContextBeforeModesTestExecutionListener.class,DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,TransactionalTestExecutionListener.class,SqlScriptsTestExecutionListener.class
		})

public class EmployeeTest {
	
	

	@Autowired
	private EmployeeMapper employeeMapper;
 
	
	
	@Test
	public void allCrudEmp() { // create operation

		Employee emp = new Employee();
		emp.setCompanyName("Infosys");
		emp.setDesignation("Developer");
		emp.setDob("26-05-1994");
		emp.setEmpName("Raje");
		emp.setSal(45632.15f);
		

		assertEquals("values inserted Successfully", 0, employeeMapper.saveEmployee(emp));
		Employee emps = new Employee();
		emps.setCompanyName("HCL");
		emps.setDesignation("Tech Lead");
		emps.setDob("26-03-1984");
		emps.setEmpName("suku");
		emps.setSal(45692.15f);
		assertEquals("values inserted Successfully", 0, employeeMapper.saveEmployee(emps)); // update operation

		Employee empn = employeeMapper.getEmployee(emp.getEmpId());

		empn.setEmpName("Rahul");

		assertEquals("Values Updated Successfully", 0, employeeMapper.updateEmployee(empn));

		// Delete Operation

		assertEquals("Value Deleted Successfully", 0, employeeMapper.deleteEmployee(26));

		// Read All

		List<Employee> lim = employeeMapper.getAllEmployees();
		assertEquals("All Values fetched Successfully", lim, lim);

	}
}
