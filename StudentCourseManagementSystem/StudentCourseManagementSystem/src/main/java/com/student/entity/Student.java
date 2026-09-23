package com.student.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private String email;
    private String department;
    private String semester;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="uid")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy="student", cascade=CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();
}
