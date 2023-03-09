package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    public Employee saveData(Employee employee){
       return employeeRepositoryImpl.save(employee);

    }

    public Optional<Employee> getDataById(int empId){

        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> getAllData(){
        return employeeRepositoryImpl.findAll();
    }

    public Employee updateData(Employee employee){
        return employeeRepositoryImpl.save(employee);
    }

    public void deleteById(int empId){
        employeeRepositoryImpl.deleteById(empId);
    }
}
