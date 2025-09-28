package com.fahad.SpringMVCCrud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fahad.SpringMVCCrud.Entity.Employee;
import com.fahad.SpringMVCCrud.Repository.EmpRepo;

@Service
public class EmpSrv {
	private final EmpRepo empRepo;
	
	public EmpSrv(EmpRepo empRepo) {
		this.empRepo = empRepo;
	}
	
    // ✅ Create or Update Employee
    public Employee saveEmp(Employee emp) {
        return empRepo.save(emp);
    }

    // ✅ Get all Employees
    public List<Employee> getAllEmps() {
        return empRepo.findAll();
    }

    // ✅ Get Employee by ID
    public Optional<Employee> getEmpById(Long id) {
        return empRepo.findById(id);
    }

    // ✅ Update Employee
    public Employee updateEmp(Long id, Employee updatedEmp) {
        return empRepo.findById(id)
                .map(emp -> {
                    emp.setName(updatedEmp.getName());
                    emp.setEmail(updatedEmp.getEmail());
                    emp.setDob(updatedEmp.getDob());
                    emp.setDepartment(updatedEmp.getDepartment());
                    return empRepo.save(emp);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    // ✅ Delete Employee
    public void deleteEmp(Long id) {
        empRepo.deleteById(id);
    }
	
}
