package com.EmpSystem.EmpDemo.controller;

import com.EmpSystem.EmpDemo.entity.Employee;
import com.EmpSystem.EmpDemo.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String home(Model m){

        List<Employee> emp = empService.getAllEmp();
        m.addAttribute("emp",emp);
        return "index";
    }

    @GetMapping("/addEmp")
    public String addEmp(){
        return "add_Emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee){
        System.out.println(employee);
        empService.addEmp(employee);
//        session.setAttribute("massage","Employee Added Successfully...");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m){
        Employee e = empService.getEmpById(id);
        m.addAttribute("emp",e);
        return "edit";

    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e){
        empService.addEmp(e);
//        session.setAttribute("msg","Employee Date Updated..");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id){
        empService.deleteEmp(id);
//        session.setAttribute("msg","Employee Deleted...");
        return "redirect:/";

    }
}
