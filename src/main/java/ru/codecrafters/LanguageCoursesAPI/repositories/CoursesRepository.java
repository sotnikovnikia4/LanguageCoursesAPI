package ru.codecrafters.LanguageCoursesAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.codecrafters.LanguageCoursesAPI.models.Course;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoursesRepository extends JpaRepository<Course, UUID> {
    List<Course> findAllByTeacherId(UUID teacherId);
}
