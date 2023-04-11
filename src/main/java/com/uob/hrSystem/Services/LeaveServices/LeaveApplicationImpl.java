package com.uob.hrSystem.Services.LeaveServices;

import com.uob.hrSystem.Models.Employee;
import com.uob.hrSystem.Models.LeaveType;
import com.uob.hrSystem.Models.LeaveTypeCategory;
import com.uob.hrSystem.Repositories.Employee.EmployeeRepository;
import com.uob.hrSystem.Repositories.Leave.LeaveCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveApplicationImpl implements LeaveApplication{

    @Autowired
    private LeaveCategoryRepository leaveCategoryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

//  employee
    @Override
    public Employee registerEmpployee(Employee employee) {
        employee = new Employee(employee.getEmployeeId(),employee.getName(),employee.getEmail(),employee.getPassword());
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    //    Leave
    @Override
    public void addLeaveType(LeaveTypeCategory leaveTypeCategory) {
        leaveCategoryRepository.save(new LeaveTypeCategory(leaveTypeCategory.getTypeId(), LeaveType.ANNUAL_LEAVE));
        leaveCategoryRepository.save(new LeaveTypeCategory(leaveTypeCategory.getTypeId(), LeaveType.EMERGENCY_LEAVE));
        leaveCategoryRepository.save(new LeaveTypeCategory(leaveTypeCategory.getTypeId(), LeaveType.SICK_LEAVE));
        leaveCategoryRepository.save(new LeaveTypeCategory(leaveTypeCategory.getTypeId(), LeaveType.WORK_FROM_HOME));
        leaveCategoryRepository.save(new LeaveTypeCategory(leaveTypeCategory.getTypeId(), LeaveType.BLOCKED_LEAVE));
    }

    @Override
    public Iterable<LeaveTypeCategory> getLeaveTypes() {
        return leaveCategoryRepository.findAll();
    }
}
