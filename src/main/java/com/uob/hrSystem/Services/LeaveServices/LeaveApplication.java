package com.uob.hrSystem.Services.LeaveServices;

import com.uob.hrSystem.Models.Accounts.Employee;
import com.uob.hrSystem.Models.Leave.Leave;
import com.uob.hrSystem.Models.Leave.LeaveTypeCategory;


public interface LeaveApplication {

//    Employee
    public Employee registerEmpployee(Employee employee);
    Iterable<Employee> getEmployees();

//    Leave
    public Leave requestLeave(int id,Leave leave);
    public Leave updateStatus(int svId,int empId,int leaveId, Leave leave);
    public void addLeaveType(LeaveTypeCategory leaveTypeCategory);
    public Iterable<LeaveTypeCategory> getLeaveTypes();
}
