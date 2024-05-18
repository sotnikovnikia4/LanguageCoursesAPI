package ru.codecrafters.LanguageCoursesAPI.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.codecrafters.LanguageCoursesAPI.exceptions.CourseException;
import ru.codecrafters.LanguageCoursesAPI.models.Course;
import ru.codecrafters.LanguageCoursesAPI.repositories.CoursesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoursesService {
    private final CoursesRepository coursesRepository;

    public Course create(Course courseToCreate) {
        coursesRepository.save(courseToCreate);

        return courseToCreate;
    }

    @Transactional
    public void setTeacher(Course course, UUID teacherId){
        course.setTeacherId(teacherId);
    }

    public List<Course> getCoursesByTeacher(UUID teacherId) {
        return coursesRepository.findAllByTeacherId(teacherId);
    }

    public void update(Course updatedCourse) {
        Optional<Course> courseToBeUpdated = coursesRepository.findById(updatedCourse.getId());
        if(courseToBeUpdated.isEmpty()){
            throw new CourseException("Такого курса не существует");
        }

        courseToBeUpdated.get().setTitle(updatedCourse.getTitle());
        courseToBeUpdated.get().setMinAge(updatedCourse.getMinAge());
        courseToBeUpdated.get().setMaxAge(updatedCourse.getMaxAge());
    }

    public void delete(UUID courseId) {
        coursesRepository.deleteById(courseId);
    }
}