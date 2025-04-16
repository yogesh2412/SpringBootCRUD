package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtServcie;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtServcie empMgmtService;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Model model) {
		List<Employee> empsList = empMgmtService.getAllEmployees();
		model.addAttribute("empsList", empsList);
		return "show_report";
	}

	@GetMapping("/register")
	public String showEmployeeRegistrationPage(@ModelAttribute("emp") Employee emp) {
		return "register_employee";
	}

	@PostMapping("/register")
	public String registerEmployee(RedirectAttributes redirectAttributes, @ModelAttribute("emp") Employee emp) {
		try {
			List<Employee> empsList = empMgmtService.getAllEmployees();

			String msg = empMgmtService.registerEmployee(emp);
			redirectAttributes.addFlashAttribute("resultMsg", msg);
			redirectAttributes.addFlashAttribute("empsList", empsList);
			return "redirect:/report"; // Redirect to the report endpoint
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMsg", "Registration failed: " + e.getMessage());
			return "redirect:/report";
		}
	}

	@GetMapping("/edit")
	public String showEditForm(@RequestParam("no") int empno, Model model) {
		Optional<Employee> optionalEmp = empMgmtService.getEmployeeById(empno);
		if (optionalEmp.isPresent()) {
			model.addAttribute("emp", optionalEmp.get());
			return "editEmployee"; // Name of your edit form JSP
		} else {
			model.addAttribute("errorMsg", "Employee not found");
			return "redirect:/report"; // Redirect to report with an error message
		}
	}

	// Endpoint to handle the submission of the updated employee data
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes redirectAttributes) {
		try {
			Employee updatedEmp = empMgmtService.updateEmployeeById(emp); // Assuming your service has an update method
																			// that takes the entire Employee object

			if (updatedEmp != null) {
				redirectAttributes.addFlashAttribute("resultMsg", "Employee updated successfully");
			} else {
				redirectAttributes.addFlashAttribute("errorMsg",
						"Employee update failed. Employee not found or data invalid.");
			}
			return "redirect:/report"; // Redirect back to the report page
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMsg", "Employee update failed: " + e.getMessage());
			return "redirect:/edit?no=" + emp.getEmpno(); // Redirect back to the edit form with error
		}
	}

	@PostMapping("/delete/{id}") // Use PostMapping for deletes from a form
	public String deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttributes) {
		try {
			String message = empMgmtService.deleteEmployeeById(id); // Call service method
			redirectAttributes.addFlashAttribute("resultMsg", message); // Consistent attribute name
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMsg", "Failed to delete employee: " + e.getMessage());
		}
		return "redirect:/report"; // Redirect to report
	}

}