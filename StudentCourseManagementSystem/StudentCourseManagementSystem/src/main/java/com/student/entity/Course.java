package com.student.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String courseName;

    @Column(unique=true, nullable=false)
    private String courseCode;

    private int credits;
    private String instructor;

    @JsonIgnore
    @OneToMany(mappedBy="course", cascade=CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();
}
