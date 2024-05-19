package ru.codecrafters.LanguageCoursesAPI.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codecrafters.LanguageCoursesAPI.exceptions.CourseException;
import ru.codecrafters.LanguageCoursesAPI.models.Lesson;
import ru.codecrafters.LanguageCoursesAPI.models.Level;
import ru.codecrafters.LanguageCoursesAPI.repositories.LevelsRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LevelsService {
    private final LevelsRepository levelsRepository;

    public Level getById(UUID id) {
        Optional<Level> level = levelsRepository.findById(id);

        if(level.isEmpty()){
            throw new CourseException("Нет такого уровня");
        }

        return level.get();
    }

    public void save(Level level) {
        levelsRepository.save(level);
    }
}
