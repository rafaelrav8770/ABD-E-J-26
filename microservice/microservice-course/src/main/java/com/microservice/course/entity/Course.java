package com.microservice.course.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teacher;

    public Course() {}

    public Course(Long id, String name, String teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public static CourseBuilder builder() { return new CourseBuilder(); }

    public static class CourseBuilder {
        private Long id;
        private String name;
        private String teacher;

        public CourseBuilder id(Long id) { this.id = id; return this; }
        public CourseBuilder name(String name) { this.name = name; return this; }
        public CourseBuilder teacher(String teacher) { this.teacher = teacher; return this; }
        public Course build() { return new Course(id, name, teacher); }
    }
}
