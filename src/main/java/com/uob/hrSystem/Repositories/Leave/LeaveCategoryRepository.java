package com.uob.hrSystem.Repositories.Leave;

import com.uob.hrSystem.Models.Leave.LeaveTypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveCategoryRepository extends JpaRepository<LeaveTypeCategory, Integer> {
}
