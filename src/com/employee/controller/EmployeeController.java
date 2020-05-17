package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired

	EmployeeService empServ

	

	@RequestMapping("/")
	public ModelAndView hel() {
		return new ModelAndView("index")
	}

	
	@RequestMapping("/addEmployee")
	public ModelAndView saveSamp(@ModelAttribute("emplo") Employee emp) {

		ModelAndView mdv = new ModelAndView("addemploy");

		mdv.addObject("employee", new Employee());

		return mdv;
	}


	

	

	@PostMapping("/saveEmployee")
	public ModelAndView saveSamples(@ModelAttribute("emplo") Employee employee) {

		System.out.println("value is :" + employee.getEmpName());

		empServ.saveEmployee(employee);

		return new ModelAndView("redirect:/listEmployee");
	}

	
	

	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
	public ModelAndView listSamp() {

		ModelAndView mdv = new ModelAndView("listemploy");

		List<Employee> list = empServ.getAllEmployees();

		mdv.addObject("lis", list);

		return mdv;
	}

	@RequestMapping("/deleteEmployee/{empId}")
	public ModelAndView deleteSample(@PathVariable("empId") int empId) {

		System.out.println("\ndelete sapid =" + empId);
		empServ.deleteEmployee(empId);

		return new ModelAndView("redirect:/listEmployee");
	}

	@RequestMapping("/updateEmployee/{empId}")
	public ModelAndView updateSample(@ModelAttribute("emplo") Employee emp, @PathVariable("empId") int empId) {

		Employee empl = empServ.getEmployee(empId);
		ModelAndView mdv = new ModelAndView("editpage", "employee", empl);

		return mdv;
	}

	@PostMapping("/saveEmployeetwo/{empId}")
	public ModelAndView saveSamplesTwo(@ModelAttribute("emplo") Employee emply, @PathVariable("empId") int empId) {
		Employee empll = empServ.getEmployee(empId);
		if (empll.getEmpId() == empId) {
			empServ.update(emply);
		}

		return new ModelAndView("redirect:/listEmployee");
	}

}
