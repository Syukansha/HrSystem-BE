package com.uob.hrSystem;

import com.uob.hrSystem.Models.Accounts.Employee;
import com.uob.hrSystem.Models.Accounts.Roles;
import com.uob.hrSystem.Models.Leave.LeaveDetails;
import com.uob.hrSystem.Repositories.Employee.EmployeeRepository;
import com.uob.hrSystem.Services.LeaveServices.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrSystemApplication implements CommandLineRunner {

	@Autowired
	private LeaveApplication leaveApplication;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(HrSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LeaveDetails leaveTypeCategory = new LeaveDetails();
		leaveApplication.addLeaveType(leaveTypeCategory);

		employeeRepository.save(new Employee("user","user","user@gmail.com","$2a$12$7Xv1901WPmfVjJBpvSNmNudf1ORnN89RBHtoaa81qdnLpuUxR6gPu","Manager",25,12312434,"CEO", Roles.USER));

	}
}
