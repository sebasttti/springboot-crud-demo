package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.domain.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployees() {
		return this.employeeDAO.findAll();
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
		Optional<Employee> employee = this.employeeDAO.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE  )
	@ResponseBody
	public String addEmployee(@RequestBody Employee employee) {
		this.employeeDAO.saveAndFlush(employee);
		return "EXITO";
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployee(@PathVariable(name = "id") Integer id, @RequestBody Employee employee) {
		Employee tempEmployee = this.employeeDAO.getById(id);
		tempEmployee.setName(employee.getName());
		tempEmployee.setEmail(employee.getEmail());
		this.employeeDAO.saveAndFlush(tempEmployee);
		return "EXITO";
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmployee(@PathVariable(name = "id") Integer id) {
		this.employeeDAO.deleteById(id);
		this.employeeDAO.flush();
		return "EXITO";
	}

}
