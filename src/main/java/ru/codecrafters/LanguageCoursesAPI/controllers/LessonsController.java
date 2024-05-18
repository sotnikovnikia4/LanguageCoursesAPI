package ru.codecrafters.LanguageCoursesAPI.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.codecrafters.LanguageCoursesAPI.dto.CreationLessonDTO;
import ru.codecrafters.LanguageCoursesAPI.dto.LessonDTO;
import ru.codecrafters.LanguageCoursesAPI.models.Lesson;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class LessonsController {
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    public LessonDTO create(@RequestBody CreationLessonDTO creationLessonDTO){
        Lesson lesson = modelMapper.map(creationLessonDTO, Lesson.class);


    }
}
