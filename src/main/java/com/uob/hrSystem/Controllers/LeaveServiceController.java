package com.uob.hrSystem.Controllers;

import com.uob.hrSystem.Models.Accounts.Employee;
import com.uob.hrSystem.Models.Leave.LeaveRequest;
import com.uob.hrSystem.Models.Leave.LeaveDetails;
import com.uob.hrSystem.Repositories.Leave.LeaveRepository;
import com.uob.hrSystem.Services.LeaveServices.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/leave_services")
public class LeaveServiceController {

    @Autowired
    private LeaveApplication leaveApplication;

    @Autowired
    private LeaveRepository leaveRepository;
    @GetMapping("/testing")
    private String testHello(){
        return "Hello testing";
    }

//    Employee
    @PostMapping("/register-employee")
    private ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee){
        try {
            return ResponseEntity.ok().body(leaveApplication.registerEmployee(employee));
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update-employee/{id}")
    private ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        try {
            return ResponseEntity.ok().body(leaveApplication.updateEmployee(id, employee));
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-employee/{id}")
    private void updateEmployee(@PathVariable int id){
      leaveApplication.deleteEmployee(id);

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


//    LeaveRequest
    @GetMapping("/leave-types")
    private ResponseEntity<Iterable<LeaveDetails>> getLeaveTypes(){
        try {
            return ResponseEntity.ok().body(leaveApplication.getLeaveTypes());
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/leave-request/employee/{id}")
    private ResponseEntity<LeaveRequest> requestLeave(@PathVariable int id, @RequestBody LeaveRequest leave){
        try {
            return ResponseEntity.ok().body(leaveApplication.requestLeave(id, leave));
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update-request/{svId}/{empId}/{leaveId}")
    private ResponseEntity<LeaveRequest> updateRequest(@PathVariable int svId, @PathVariable int empId, @PathVariable int leaveId, LeaveRequest leave){
        try {
            return ResponseEntity.ok().body(leaveApplication.updateStatus(svId,empId,leaveId,leave));
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/leave-transaction/employee/{id}")
    private ResponseEntity<List<LeaveRequest>> getListLeave(@PathVariable int id){
        try {
            return ResponseEntity.ok().body(leaveRepository.getListLeave(id));
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
