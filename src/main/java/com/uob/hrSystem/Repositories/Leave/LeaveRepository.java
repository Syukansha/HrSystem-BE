package com.uob.hrSystem.Repositories.Leave;

import com.uob.hrSystem.Models.Leave.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Integer> {
    @Query("select l from LeaveRequest l where employee_id like %?1%")
    public List<LeaveRequest> getListLeave(int id);
}
