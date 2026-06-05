package com.microservice.course;

import com.microservice.course.client.StudentClient;
import com.microservice.course.controller.sto.StudentDTO;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCouseResponse;
import com.microservice.course.persistence.ICourseRepository;
import com.microservice.course.service.CourseServiceImpl;
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
class MicroserviceCourseApplicationTests {

    @Mock
    private ICourseRepository courseRepository;

    @Mock
    private StudentClient studentClient;

    @InjectMocks
    private CourseServiceImpl courseService;

    private Course course;

    @BeforeEach
    void setUp() {
        course = Course.builder()
                .id(1L)
                .name("Base de Datos")
                .teacher("Aquino")
                .build();
    }

    @Test
    void guardarCurso() {
        courseService.save(course);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void obtenerTodosLosCursos() {
        List<Course> lista = Arrays.asList(course,
                Course.builder().id(2L).name("Artística").teacher("Aquino").build());
        when(courseRepository.findAll()).thenReturn(lista);

        List<Course> resultado = courseService.findAll();

        assertEquals(2, resultado.size());
        assertEquals("Base de Datos", resultado.get(0).getName());
    }

    @Test
    void obtenerCursoPorId() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Course resultado = courseService.findById(1L);

        assertNotNull(resultado);
        assertEquals("Aquino", resultado.getTeacher());
    }

    @Test
    void eliminarCurso() {
        courseService.deleteById(1L);
        verify(courseRepository, times(1)).deleteById(1L);
    }

    @Test
    void actualizarCurso() {
        Course actualizado = Course.builder()
                .name("Base de Datos Avanzado").teacher("Aquino").build();

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        courseService.update(1L, actualizado);

        verify(courseRepository, times(1)).save(any(Course.class));
        assertEquals("Base de Datos Avanzado", course.getName());
    }

    @Test
    void obtenerEstudiantesPorCurso() {
        List<StudentDTO> estudiantes = Arrays.asList(
                new StudentDTO("Juan", "Pérez", "juan@email.com", 1L),
                new StudentDTO("María", "López", "maria@email.com", 1L)
        );

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(studentClient.findAllStudentByCourse(1L)).thenReturn(estudiantes);

        StudentByCouseResponse response = courseService.findStudentsByCourseId(1L);

        assertNotNull(response);
        assertEquals("Base de Datos", response.getCourseName());
        assertEquals(2, response.getStudentDTOList().size());
    }
}
