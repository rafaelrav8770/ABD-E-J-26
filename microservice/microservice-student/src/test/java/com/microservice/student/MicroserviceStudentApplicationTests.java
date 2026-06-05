package com.microservice.student;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;
import com.microservice.student.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MicroserviceStudentApplicationTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .id(1L)
                .name("Juan")
                .lastName("Pérez")
                .email("juan@email.com")
                .courseId(1L)
                .build();
    }

    @Test
    void guardarEstudiante() {
        studentService.save(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void obtenerTodosLosEstudiantes() {
        List<Student> lista = Arrays.asList(student,
                Student.builder().id(2L).name("María").lastName("López")
                        .email("maria@email.com").courseId(1L).build());
        when(studentRepository.findAll()).thenReturn(lista);

        List<Student> resultado = studentService.findAll();

        assertEquals(2, resultado.size());
        assertEquals("Juan", resultado.get(0).getName());
    }

    @Test
    void obtenerEstudiantePorId() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student resultado = studentService.findById(1L);

        assertNotNull(resultado);
        assertEquals("juan@email.com", resultado.getEmail());
    }

    @Test
    void obtenerEstudiantesPorCurso() {
        when(studentRepository.findAllByCourseId(1L)).thenReturn(Arrays.asList(student));

        List<Student> resultado = studentService.findByCourseId(1L);

        assertEquals(1, resultado.size());
        assertEquals(1L, resultado.get(0).getCourseId());
    }

    @Test
    void eliminarEstudiante() {
        studentService.deleteById(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void actualizarEstudiante() {
        Student actualizado = Student.builder()
                .name("Juan Carlos").lastName("Pérez")
                .email("juanc@email.com").courseId(2L).build();

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        studentService.update(1L, actualizado);

        verify(studentRepository, times(1)).save(any(Student.class));
        assertEquals("Juan Carlos", student.getName());
        assertEquals("juanc@email.com", student.getEmail());
    }
}
