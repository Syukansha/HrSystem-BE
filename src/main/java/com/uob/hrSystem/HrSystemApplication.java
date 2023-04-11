package com.uob.hrSystem;

import com.uob.hrSystem.Models.LeaveTypeCategory;
import com.uob.hrSystem.Services.LeaveServices.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrSystemApplication implements CommandLineRunner {

	@Autowired
	private LeaveApplication leaveApplication;

	public static void main(String[] args) {
		SpringApplication.run(HrSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LeaveTypeCategory leaveTypeCategory = new LeaveTypeCategory();
		leaveApplication.addLeaveType(leaveTypeCategory);

	}
}
