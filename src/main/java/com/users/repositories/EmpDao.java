package com.users.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.users.model.Employee;

@Repository
public interface EmpDao extends CrudRepository<Employee, Serializable> {
	
}