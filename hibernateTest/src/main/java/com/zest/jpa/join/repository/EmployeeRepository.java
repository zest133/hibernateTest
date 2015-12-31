package com.zest.jpa.join.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zest.jpa.join.Employee;
import com.zest.jpa.manytomanyextracolumn.Person;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>{

}