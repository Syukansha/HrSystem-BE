package com.uob.hrSystem.Services.LeaveServices;

import com.uob.hrSystem.Exception.NotFoundException;
import com.uob.hrSystem.Models.Accounts.Employee;
import com.uob.hrSystem.Models.Leave.Leave;
import com.uob.hrSystem.Models.Leave.LeaveType;
import com.uob.hrSystem.Models.Leave.LeaveDetails;
import com.uob.hrSystem.Models.Leave.Status;
import com.uob.hrSystem.Repositories.Employee.EmployeeRepository;
import com.uob.hrSystem.Repositories.Leave.LeaveCategoryRepository;
import com.uob.hrSystem.Repositories.Leave.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveApplicationImpl implements LeaveApplication{

    @Autowired
    private LeaveCategoryRepository leaveCategoryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;


//  employee
    @Override
    public Employee registerEmpployee(Employee employee) {
        employee = new Employee(employee.getEmployeeId(),employee.getName(),employee.getUsername(),employee.getEmail(),employee.getPassword(),employee.getPosition(),employee.getAnnualLeave(),employee.getPhoneNum(),employee.getReportTo());
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }




    //    Leave
    @Override
    public Leave requestLeave(int id, Leave leave) {

        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent()){
            Employee emp = employeeData.get();

            leave = new Leave(leave.getLeaveId(),emp, leave.getStartDate(),leave.getEndDate(),leave.getApplyDate(),leave.getRejectDate(), leave.getApprovedBy(), leave.getRejectedBy(), Status.PENDING,leave.getDescription());
            return leaveRepository.save(leave);
        }
        else throw new NotFoundException("Have problem while trying to register leave");
    }

    @Override
    public Leave updateStatus(int svId, int empId, int leaveId, Leave leave) {
        Optional empData = employeeRepository.findById(empId);
        Optional svData = employeeRepository.findById(svId);
        Optional leaveData = leaveRepository.findById(leaveId);

        if(empData.isPresent() && svData.isPresent()){
            Employee emp =(Employee) empData.get();
            Employee sv = (Employee) svData.get();
            Leave _leave = (Leave) leaveData.get();

            if(emp.getReportTo().equalsIgnoreCase(sv.getUsername())){
                _leave.setStatus(Status.APPROVED);
                return leaveRepository.save(_leave);
            }

        }
        return null;
    }

    private List<Leave> getListLeave(int id){
        List<Leave> leaveData = new ArrayList<Leave>();

        if(id == 0){
            leaveRepository.findAll().forEach(leaveData::add);
        }else {
            getListLeave(id).forEach(leaveData::add);
        }
        return leaveData;
    }

    @Override
    public void addLeaveType(LeaveDetails leaveTypeCategory) {
        leaveCategoryRepository.save(new LeaveDetails(leaveTypeCategory.getTypeId(), LeaveType.ANNUAL_LEAVE));
        leaveCategoryRepository.save(new LeaveDetails(leaveTypeCategory.getTypeId(), LeaveType.EMERGENCY_LEAVE));
        leaveCategoryRepository.save(new LeaveDetails(leaveTypeCategory.getTypeId(), LeaveType.SICK_LEAVE));
        leaveCategoryRepository.save(new LeaveDetails(leaveTypeCategory.getTypeId(), LeaveType.WORK_FROM_HOME));
        leaveCategoryRepository.save(new LeaveDetails(leaveTypeCategory.getTypeId(), LeaveType.BLOCKED_LEAVE));
    }

    @Override
    public Iterable<LeaveDetails> getLeaveTypes() {
        return leaveCategoryRepository.findAll();
    }
}
