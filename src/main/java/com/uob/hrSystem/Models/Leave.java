package com.uob.hrSystem.Models;

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
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int leaveId;
    @OneToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    private Date startDate;
    private Date endDate;

    private String status;
    private String description;
    private int phoneNum;

}
