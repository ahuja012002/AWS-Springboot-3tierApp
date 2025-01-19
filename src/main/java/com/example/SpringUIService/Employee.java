package com.example.SpringUIService;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name="employee_city")
	private String employeeCity;
	@Column(name = "employee_country")
	private String employeeCountry;
	@Column (name = "employee_role")
	private String employeeRole;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee(Long id, String employeeName, String employeeCity, String employeeCountry, String employeeRole) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeCity = employeeCity;
		this.employeeCountry = employeeCountry;
		this.employeeRole = employeeRole;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Employee() {
	
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	public String getEmployeeCountry() {
		return employeeCountry;
	}
	public void setEmployeeCountry(String employeeCountry) {
		this.employeeCountry = employeeCountry;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	
	

	

}
