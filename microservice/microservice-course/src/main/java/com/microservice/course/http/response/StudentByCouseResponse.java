package com.microservice.course.http.response;

import com.microservice.course.controller.sto.StudentDTO;
import java.util.List;

public class StudentByCouseResponse {

    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;

    public StudentByCouseResponse() {}

    public StudentByCouseResponse(String courseName, String teacher, List<StudentDTO> studentDTOList) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.studentDTOList = studentDTOList;
    }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }
    public List<StudentDTO> getStudentDTOList() { return studentDTOList; }
    public void setStudentDTOList(List<StudentDTO> studentDTOList) { this.studentDTOList = studentDTOList; }

    public static StudentByCouseResponseBuilder builder() { return new StudentByCouseResponseBuilder(); }

    public static class StudentByCouseResponseBuilder {
        private String courseName;
        private String teacher;
        private List<StudentDTO> studentDTOList;

        public StudentByCouseResponseBuilder courseName(String courseName) { this.courseName = courseName; return this; }
        public StudentByCouseResponseBuilder teacher(String teacher) { this.teacher = teacher; return this; }
        public StudentByCouseResponseBuilder studentDTOList(List<StudentDTO> studentDTOList) { this.studentDTOList = studentDTOList; return this; }
        public StudentByCouseResponse build() { return new StudentByCouseResponse(courseName, teacher, studentDTOList); }
    }
}
