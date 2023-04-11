package com.uob.hrSystem.Repositories.Leave;

import com.uob.hrSystem.Models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
}
