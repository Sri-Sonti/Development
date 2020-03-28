package com.sprinttech.dev.RestAPI;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Employee")
public class EmployeeController
{
    public List<Employee> employeesList = new ArrayList<Employee>();

    @GetMapping("/getId")
     public List<Employee> getEmployees ()
    {
       return (employeesList);
    }

    @PostMapping("/addId")
    public void addEmployee(@RequestBody Employee employee)
    {
        System.out.println(employee);
        employeesList.add(employee);

    }

    @PutMapping("/updateId/{id}")
    public void updateEmployee(@PathVariable("id") int id , @RequestBody Employee employee) {
        for (Employee employee1 : employeesList) {
            if (id == employee1.getId()) {
                int index = employeesList.indexOf(employee1);
                employeesList.set(index, employee);

            }

        }

    }


}
