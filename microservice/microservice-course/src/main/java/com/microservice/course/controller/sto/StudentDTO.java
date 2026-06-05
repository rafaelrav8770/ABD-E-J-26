package com.microservice.course.controller.sto;

public class StudentDTO {
    private String name;
    private String lastName;
    private String email;
    private Long courseId;

    public StudentDTO() {}

    public StudentDTO(String name, String lastName, String email, Long courseId) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.courseId = courseId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public static StudentDTOBuilder builder() { return new StudentDTOBuilder(); }

    public static class StudentDTOBuilder {
        private String name;
        private String lastName;
        private String email;
        private Long courseId;

        public StudentDTOBuilder name(String name) { this.name = name; return this; }
        public StudentDTOBuilder lastName(String lastName) { this.lastName = lastName; return this; }
        public StudentDTOBuilder email(String email) { this.email = email; return this; }
        public StudentDTOBuilder courseId(Long courseId) { this.courseId = courseId; return this; }
        public StudentDTO build() { return new StudentDTO(name, lastName, email, courseId); }
    }
}
