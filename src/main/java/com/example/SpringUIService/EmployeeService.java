package com.example.SpringUIService;

import java.util.List;

import org.springframework.data.domain.Page;


public interface EmployeeService {

	Employee saveEmployeeData(Employee userEntity);
    List<Employee> getEmployeeData();
    Employee updateEmployeeData(Employee userEntity);
    Employee getEmployeeById(long id);

    void deleteEmployeeData(Long id);
    public Page<Employee> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);
}
