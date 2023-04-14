package com.uob.hrSystem.Models.Leave;

import com.uob.hrSystem.Models.Accounts.Employee;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private Status status;
    private String description;


}
