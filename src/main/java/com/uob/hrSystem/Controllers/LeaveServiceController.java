package com.uob.hrSystem.Controllers;

import com.uob.hrSystem.Models.Employee;
import com.uob.hrSystem.Models.LeaveTypeCategory;
import com.uob.hrSystem.Services.LeaveServices.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/leave_services")
public class LeaveServiceController {

    @Autowired
    private LeaveApplication leaveApplication;
    @GetMapping("/testing")
    private String testHello(){
        return "Hello testing";
    }

//    Employee
    @PostMapping("/register-employee")
    private ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee){
        try {
            return ResponseEntity.ok().body(leaveApplication.registerEmpployee(employee));
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees")
    private ResponseEntity<Iterable<Employee>> getEmployees(){
        try {
            return ResponseEntity.ok().body(leaveApplication.getEmployees());
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/leave-types")
    private ResponseEntity<Iterable<LeaveTypeCategory>> getLeaveTypes(){
//        return leaveApplication.getLeaveTypes();
        try {
            return ResponseEntity.ok().body(leaveApplication.getLeaveTypes());
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
