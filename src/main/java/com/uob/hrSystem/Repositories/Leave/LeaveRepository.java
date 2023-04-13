package com.uob.hrSystem.Repositories.Leave;

import com.uob.hrSystem.Models.Leave.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    @Query("select l from Leave l where employee_id like %?1%")
    public List<Leave> getListLeave(int id);
}
