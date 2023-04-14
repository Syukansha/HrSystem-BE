package com.uob.hrSystem.Repositories.Leave;

import com.uob.hrSystem.Models.Leave.LeaveDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveCategoryRepository extends JpaRepository<LeaveDetails, Integer> {
}
