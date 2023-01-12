package com.EmpSystem.EmpDemo.repository;

import com.EmpSystem.EmpDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {

}
