package com.fahad.SpringMVCCrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fahad.SpringMVCCrud.Entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
