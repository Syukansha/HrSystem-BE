package com.uob.hrSystem.Models.Accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String username;

    private String email;
    private String password;
    private String position;
    private int annualLeave;
    private int phoneNum;

    private String reportTo;

    public Employee(String username, String email, String password, String position, int annualLeave, int phoneNum, String reportTo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.position = position;
        this.annualLeave = annualLeave;
        this.phoneNum = phoneNum;
        this.reportTo = reportTo;
    }
}
