package com.placement.placement.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "placement")
@Data
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "placement_date")
    private LocalDate placementDate;

    @Column(name = "student_id")
    private Long studentId;

}
