package com.zest.jpa.manytomanyextracolumn.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zest.jpa.manytomanyextracolumn.Person;


public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>{

}