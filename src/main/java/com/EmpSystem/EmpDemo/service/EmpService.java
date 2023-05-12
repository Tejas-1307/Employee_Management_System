package com.EmpSystem.EmpDemo.service;

import com.EmpSystem.EmpDemo.entity.Employee;
import com.EmpSystem.EmpDemo.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo empRepo;

    public  void addEmp(Employee employee){
        empRepo.save(employee);
    }

    public List<Employee> getAllEmp(){
        return empRepo.findAll();
    }

    public Employee getEmpById(int id){
         Optional<Employee> e =empRepo.findById(id);
         if (e.isPresent()){
             return e.get();
         }
         return null;
    }

    public void deleteEmp(int id){
        empRepo.deleteById(id);
    }
}


