package com.uob.hrSystem.Services.AccountService;

import com.uob.hrSystem.Models.Account.Department.DepartmentTypes;
import com.uob.hrSystem.Models.Account.EmployeeType;
import com.uob.hrSystem.Models.Account.Role.Role;
import com.uob.hrSystem.Models.Account.Role.RoleTypes;
import com.uob.hrSystem.Models.Account.Users;
import com.uob.hrSystem.Models.Account.Vendor.VendorTypes;
import com.uob.hrSystem.Repositories.Account.UserRepository;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountApplicationImpl implements AccountApplication{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users addAccount(Users users) {
        users = new Users(users.getId(),users.getName(),users.getUsername(),users.getPassword(),users.getPosition(), RoleTypes.EMPLOYEE,users.getManager_id(),DepartmentTypes.DIGITAL_BANKING,users.getPhone_num(),users.getEmail(),users.getAddress(),users.getHire_date(), EmployeeType.VENDOR, VendorTypes.ACCENTURE);
        return userRepository.save(users);
    }

    @Override
    public Users updateAccount(Users users, long id) {
        Optional<Users> userData = userRepository.findById(id);
        if(userData.isPresent()){
            Users _user = userData.get();

            _user.setName(users.getName());
            _user.setUsername(users.getUsername());
            _user.setPosition(users.getPosition());
            _user.setRoleTypes(RoleTypes.EMPLOYEE);
            _user.setManager_id(users.getManager_id());
            _user.setDepartmentTypes(DepartmentTypes.DIGITAL_BANKING);
            _user.setPhone_num(users.getPhone_num());
            _user.setEmail(users.getEmail());
            _user.setAddress(users.getAddress());
            _user.setHire_date(users.getHire_date());
            _user.setEmployeeType(EmployeeType.VENDOR);
            _user.setVendorTypes(VendorTypes.ACCENTURE);

            return userRepository.save(_user);
        }
        return null;
    }
}
