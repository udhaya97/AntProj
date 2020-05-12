package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeUtil;
import com.employee.model.Employee;

@Repository

public class EmployeeMapper {
	
	EmployeeUtil empUtil = new EmployeeUtil();

	public List<Employee> getAllEmployees()
	{
		SqlSession sqlSession = empUtil.getSqlSessionFactory().openSession();
		
		System.out.println("\n before list of values in mapper");List<Employee> lis = new ArrayList<>();
		lis= sqlSession.selectList("getEmployeeDetail");
		System.out.println("\n getting values for employee mapper");
		sqlSession.commit();
		sqlSession.close();
		return lis;
	}
	
	public int saveEmployee(Employee  employe)
	{
		SqlSession session = empUtil.getSqlSessionFactory().openSession();
		
		session.insert("insetValues", employe);
		
		session.commit();
		session.close();
		
		return 0;
	}
	public int deleteEmployee(int empId)
	{
		SqlSession session = empUtil.getSqlSessionFactory().openSession();
		
		session.delete("deleteEmployee",empId);	
		session.commit();
		session.close();
		
		return 0;
	}
	
	public Employee getEmployee(int empId)
	{
		SqlSession session = empUtil.getSqlSessionFactory().openSession();
		
		Employee sample =(Employee) session.selectOne("getEmployee",empId);	
		
		session.commit();
		session.close();
		
		return sample;
	}
	public int updateEmployee(Employee employee)
	{
		SqlSession session = empUtil.getSqlSessionFactory().openSession();
		
	 session.update("updateEmployee", employee);
		session.commit();
		session.close();
		
		return 0;
	}
}
