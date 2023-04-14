package com.uob.hrSystem.Services.LeaveServices;

import com.uob.hrSystem.Models.Accounts.Employee;
import com.uob.hrSystem.Models.Leave.LeaveRequest;
import com.uob.hrSystem.Models.Leave.LeaveDetails;


public interface LeaveApplication {

//    Employee
    public Employee registerEmployee(Employee employee);
    Iterable<Employee> getEmployees();
    Employee updateEmployee(int id, Employee employee);
    public void deleteEmployee(int id);

//    LeaveRequest
    public LeaveRequest requestLeave(int id, LeaveRequest leave);
    public LeaveRequest updateStatus(int svId, int empId, int leaveId, LeaveRequest leave);
    public void addLeaveType(LeaveDetails leaveTypeCategory);
    public Iterable<LeaveDetails> getLeaveTypes();
}
