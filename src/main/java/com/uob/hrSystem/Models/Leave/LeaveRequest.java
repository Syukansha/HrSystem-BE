package com.uob.hrSystem.Models.Leave;

<<<<<<<< HEAD:src/main/java/com/uob/hrSystem/Models/Leave/Leave.java
import com.uob.hrSystem.Models.Employee.Employee;
========
import com.uob.hrSystem.Models.Accounts.Employee;
>>>>>>>> features/jwt-security:src/main/java/com/uob/hrSystem/Models/Leave/LeaveRequest.java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEAVE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LeaveRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaveId;
    @OneToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    private Date startDate;
    private Date endDate;

    private Date applyDate;
    private Date rejectDate;
    private String ApprovedBy;
    private String rejectedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private Status status;
    private String description;


}
