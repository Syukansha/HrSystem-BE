package com.uob.hrSystem.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LEAVE_CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveTypeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private LeaveType leaveType;


}
