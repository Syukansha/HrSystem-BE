package com.uob.hrSystem.Services.AccountService;

import com.uob.hrSystem.Models.Account.Department.DepartmentTypes;
import com.uob.hrSystem.Models.Account.EmployeeType;
import com.uob.hrSystem.Models.Account.Role.Role;
import com.uob.hrSystem.Models.Account.Role.RoleTypes;
import com.uob.hrSystem.Models.Account.Users;
import com.uob.hrSystem.Models.Account.Vendor.VendorTypes;
import com.uob.hrSystem.Repositories.Account.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountApplicationImpl implements AccountApplication{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users addAccount(Users users) {
        users = new Users(users.getId(),users.getName(),users.getUsername(),users.getPassword(),users.getPosition(), RoleTypes.EMPLOYEE,users.getManager_id(),DepartmentTypes.DIGITAL_BANKING,users.getPhone_num(),users.getEmail(),users.getAddress(),users.getHire_date(), EmployeeType.VENDOR, VendorTypes.ACCENTURE);
        return userRepository.save(users);
    }
}
