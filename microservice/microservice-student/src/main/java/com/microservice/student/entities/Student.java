package com.microservice.student.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "course_id")
    private Long courseId;

    public Student() {}

    public Student(Long id, String name, String lastName, String email, Long courseId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.courseId = courseId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public static StudentBuilder builder() { return new StudentBuilder(); }

    public static class StudentBuilder {
        private Long id;
        private String name;
        private String lastName;
        private String email;
        private Long courseId;

        public StudentBuilder id(Long id) { this.id = id; return this; }
        public StudentBuilder name(String name) { this.name = name; return this; }
        public StudentBuilder lastName(String lastName) { this.lastName = lastName; return this; }
        public StudentBuilder email(String email) { this.email = email; return this; }
        public StudentBuilder courseId(Long courseId) { this.courseId = courseId; return this; }
        public Student build() { return new Student(id, name, lastName, email, courseId); }
    }
}
