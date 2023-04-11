package com.uob.hrSystem.Services.LeaveServices;

import com.uob.hrSystem.Exception.NotFoundException;
import com.uob.hrSystem.Models.Employee;
import com.uob.hrSystem.Models.Leave;
import com.uob.hrSystem.Models.LeaveType;
import com.uob.hrSystem.Models.LeaveTypeCategory;
import com.uob.hrSystem.Repositories.Employee.EmployeeRepository;
import com.uob.hrSystem.Repositories.Leave.LeaveCategoryRepository;
import com.uob.hrSystem.Repositories.Leave.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class LeaveApplicationImpl implements LeaveApplication{

    @Autowired
    private LeaveCategoryRepository leaveCategoryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    private static final String status = "PENDING";

//  employee
    @Override
    public Employee registerEmpployee(Employee employee) {
        employee = new Employee(employee.getEmployeeId(),employee.getName(),employee.getEmail(),employee.getPassword(),employee.getPosition(),employee.getAnnualLeave(),employee.getPhoneNum(),employee.getReportTo());
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Leave requestLeave(int id,Leave leave) {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent()){
            Employee emp = employeeData.get();
            leave = new Leave(leave.getLeaveId(),emp,leave.getStartDate(),leave.getEndDate(),status,leave.getDescription());
            return leaveRepository.save(leave);
        }
        else throw new NotFoundException("Have problem while trying to register leave");
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
