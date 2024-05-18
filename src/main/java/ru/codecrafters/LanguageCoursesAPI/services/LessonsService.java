package ru.codecrafters.LanguageCoursesAPI.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codecrafters.LanguageCoursesAPI.exceptions.CourseException;
import ru.codecrafters.LanguageCoursesAPI.models.Course;
import ru.codecrafters.LanguageCoursesAPI.models.Lesson;
import ru.codecrafters.LanguageCoursesAPI.repositories.LessonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonsService {
    private final LessonRepository lessonRepository;

    public Lesson create(Lesson lesson) {
        lessonRepository.save(lesson);

        return lesson;
    }

    public List<Lesson> getLessonsByCourseId(UUID courseId) {
        return lessonRepository.findAllByCourseId(courseId);
    }
}
