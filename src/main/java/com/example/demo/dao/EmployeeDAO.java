package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
