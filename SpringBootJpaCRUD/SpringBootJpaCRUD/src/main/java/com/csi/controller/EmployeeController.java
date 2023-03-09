package com.csi.controller;

import com.csi.constants.EndPointConstant;
import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Integer> getDataById(@PathVariable int empId){
        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("Employee Id Does Not Exist"));

        return ResponseEntity.ok(employee1.getEmpId());
    }

    @GetMapping(EndPointConstant.GET_ALL_DATA)
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId,@RequestBody Employee employee){

        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("Employee Id Does Not Exist"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("Employee Id Does Not Exist"));

        employeeServiceImpl.deleteById(employee1.getEmpId());
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
