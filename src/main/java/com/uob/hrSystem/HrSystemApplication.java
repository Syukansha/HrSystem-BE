package com.uob.hrSystem;

import com.uob.hrSystem.Models.Accounts.Employee;
import com.uob.hrSystem.Models.Leave.LeaveTypeCategory;
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
		LeaveTypeCategory leaveTypeCategory = new LeaveTypeCategory();
		leaveApplication.addLeaveType(leaveTypeCategory);

		employeeRepository.save(new Employee("user","user@gmail.com","$2a$12$7Xv1901WPmfVjJBpvSNmNudf1ORnN89RBHtoaa81qdnLpuUxR6gPu","USER",25,12312434,"CEO"));

	}
}
