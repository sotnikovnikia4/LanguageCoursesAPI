package ru.codecrafters.LanguageCoursesAPI.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthorizationAPI {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8081/classrooms/student/{studentId}/get-classrooms";
    private final ObjectMapper objectMapper;

    public List<UUID> getClassroomIdsByStudentId(UUID studentId) {
        String json = restTemplate.getForObject(url, String.class, Map.of("studentId", studentId.toString()));


        return null;
    }
}
