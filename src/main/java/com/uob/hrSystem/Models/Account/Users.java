package com.uob.hrSystem.Models.Account;

import com.uob.hrSystem.Models.Account.Department.DepartmentTypes;
import com.uob.hrSystem.Models.Account.Role.RoleTypes;
import com.uob.hrSystem.Models.Account.Vendor.VendorTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String password;
    private String position;
    @Enumerated(EnumType.STRING)
    private RoleTypes roleTypes;
    private long manager_id;
    @Enumerated(EnumType.STRING)
    @Column(name = "DEPARTMENTS")
    private DepartmentTypes departmentTypes;
    private String phone_num;
    private String email;
    private String address;
    private Date hire_date;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @Enumerated(EnumType.STRING)
    private VendorTypes vendorTypes;


}
