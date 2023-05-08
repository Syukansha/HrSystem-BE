package com.uob.hrSystem.Repositories.Account;

import com.uob.hrSystem.Models.Account.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
