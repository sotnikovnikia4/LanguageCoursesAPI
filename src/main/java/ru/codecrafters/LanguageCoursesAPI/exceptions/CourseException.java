package ru.codecrafters.LanguageCoursesAPI.exceptions;

public class CourseException extends RuntimeException{
    public CourseException(String message){
        super(message);
    }
}
