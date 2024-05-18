package ru.codecrafters.LanguageCoursesAPI.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.codecrafters.LanguageCoursesAPI.api.AuthorizationAPI;
import ru.codecrafters.LanguageCoursesAPI.dto.CourseDTO;
import ru.codecrafters.LanguageCoursesAPI.dto.CreationCourseDTO;
import ru.codecrafters.LanguageCoursesAPI.models.Course;
import ru.codecrafters.LanguageCoursesAPI.repositories.CoursesRepository;
import ru.codecrafters.LanguageCoursesAPI.services.CoursesService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class CoursesController {
    private final ModelMapper modelMapper;
    private final CoursesService coursesService;

    @PostMapping("/create_by_editor")
    public CourseDTO createCourseByEditor(@RequestBody CreationCourseDTO creationCourseDTO){
        Course courseToCreate = modelMapper.map(creationCourseDTO, Course.class);

        coursesService.create(courseToCreate);
        coursesService.setTeacher(courseToCreate, null);

        return modelMapper.map(courseToCreate, CourseDTO.class);
    }

    @PostMapping("/create_by_teacher")
    public CourseDTO createCourseByTeacher(@RequestBody CreationCourseDTO creationCourseDTO){
        Course courseToCreate = modelMapper.map(creationCourseDTO, Course.class);

        coursesService.create(courseToCreate);

        return modelMapper.map(courseToCreate, CourseDTO.class);
    }

    @GetMapping("/teacher_courses/{teacherId}")
    public List<CourseDTO> getCoursesByTeacher(@PathParam("teacherId") UUID teacherId){
        List<Course> courses = coursesService.getCoursesByTeacher(teacherId);

        return courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/editor_courses")
    public List<CourseDTO> getCoursesByEditor(@PathParam("teacherId") UUID teacherId){
        List<Course> courses = coursesService.getCoursesByTeacher(null);

        return courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/student_courses/{studentId}")
    public List<CourseDTO> getCoursesByStudent(@PathVariable("studentId") UUID studentId){//TODO

        List<Course> courses = coursesService.getCoursesByStudentId(studentId);

        return courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
    }

    @PatchMapping
    public CourseDTO editCourse(@RequestBody CourseDTO creationCourseDTO){
        Course updatedCourse = modelMapper.map(creationCourseDTO, Course.class);

        coursesService.update(updatedCourse);

        return modelMapper.map(updatedCourse, CourseDTO.class);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable UUID courseId){

        coursesService.delete(courseId);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable UUID id){
        Course course = coursesService.getCourseById(id);

        return modelMapper.map(course, CourseDTO.class);
    }
}
