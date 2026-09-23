package com.student.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="enrollments", uniqueConstraints=@UniqueConstraint(columnNames={"student_id","course_id"}))
public class Enrollment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private LocalDate enrollmentDate;
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;
}
