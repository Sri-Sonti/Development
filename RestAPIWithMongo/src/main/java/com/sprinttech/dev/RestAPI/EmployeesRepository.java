
package com.sprinttech.dev.RestAPI;

import com.sprinttech.dev.RestAPI.Employee;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends MongoRepository<Employee, String> {

   }

//    Employee findbyemail(String email) {
//        return new Employee(1,"Sri", "sonti","ww");
//    }


