package ru.codecrafters.LanguageCoursesAPI.api;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.codecrafters.LanguageCoursesAPI.dto.IdDTO;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthorizationAPI {
    private final RestTemplate restTemplate;

    public List<IdDTO> getClassroomIdsByStudentId(UUID studentId) {

    }
}
