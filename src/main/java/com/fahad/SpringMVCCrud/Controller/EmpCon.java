package com.fahad.SpringMVCCrud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fahad.SpringMVCCrud.Entity.Employee;
import com.fahad.SpringMVCCrud.Service.EmpSrv;

@Controller
@RequestMapping("/employees")
public class EmpCon {
	private final EmpSrv serv;
	
	public EmpCon(EmpSrv serv) {
		this.serv = serv;
	}
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("employees", serv.getAllEmps());
		return "employee-list";
	}
	
//    @GetMapping("/new")
//    public String showAddForm(Model model) {
//        model.addAttribute("employee", new Employee());
//        return "employee-form"; // JSP page for form
//    }
    
	@GetMapping("/new")
	public String createForm(Model model) {
	    model.addAttribute("employee", new Employee());
	    return "employee-form";
	}
    
    
    @PostMapping
    public String save(@ModelAttribute("employee") Employee emp,
                       @RequestParam("dobStr") String dobStr) {
    	if (dobStr != null && !dobStr.isBlank()) {
            emp.setDob(
                java.time.LocalDate.parse(dobStr)
                    .atStartOfDay(java.time.ZoneId.systemDefault())
                    .toInstant()
            );
        }
        serv.saveEmp(emp);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Employee emp = serv.getEmpById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id: " + id));
        model.addAttribute("employee", emp);
        return "employee-form";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
    	serv.deleteEmp(id);
        return "redirect:/employees";
    }
}
