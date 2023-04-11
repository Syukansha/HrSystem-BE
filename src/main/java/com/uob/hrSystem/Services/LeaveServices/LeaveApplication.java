package com.uob.hrSystem.Services.LeaveServices;

import com.uob.hrSystem.Models.Employee;
import com.uob.hrSystem.Models.Leave;
import com.uob.hrSystem.Models.LeaveTypeCategory;
import org.springframework.stereotype.Service;


public interface LeaveApplication {

//    Employee
    public Employee registerEmpployee(Employee employee);
    Iterable<Employee> getEmployees();

//    Leave
    public Leave requestLeave(int id,Leave leave);
    public void addLeaveType(LeaveTypeCategory leaveTypeCategory);
    public Iterable<LeaveTypeCategory> getLeaveTypes();
}
