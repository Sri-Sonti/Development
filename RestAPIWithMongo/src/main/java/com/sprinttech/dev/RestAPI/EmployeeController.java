package com.sprinttech.dev.RestAPI;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@RestController
@RequestMapping("/Employee")
public class EmployeeController
{
  //  public List<Employee> employeesList = new ArrayList<Employee>();
    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/getAll")
     public List<Employee> getEmployees ()
    {
       return (employeesRepository.findAll());
    }

    @GetMapping("/{empId}")
    public Employee getEmployee (@PathVariable String empId)
    {
                return employeesRepository.findById(empId).get();
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployee(@Valid @RequestBody List<Employee> employees)
    {
        employees.stream().forEach(employee -> employeesRepository.save(employee));
              return employees;
    }

    @PutMapping("/updateId/{empId}")
    public void updateEmployee(@PathVariable String empId , @Valid @RequestBody Employee employee) {

        if (employeesRepository.findById(empId).get() != null) {
            employeesRepository.save(employee);
        }

    }

    @PutMapping("/updateAll")
    public void updateEmployees(@Valid @RequestBody List<Employee> employees)
    {
        employees.stream().forEach(emp -> updateEmployee(emp.getEmpId(), emp));
    }

}
