package com.freightos.suseventsdetector.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightos.suseventsdetector.model.UnauthorizedUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")  // Ensure the test profile is active
public class SuspiciousEventsServiceTest {

    @Autowired
    private SuspiciousEventsService suspiciousEventsService;

    @Test
    public void captureUnauthorizedRequests() throws Exception {
        // Add log to verify test is running
        System.out.println("Running captureUnauthorizedRequests test...");

        /*ObjectMapper mapper = new ObjectMapper();
        List<UnauthorizedUser> expectedUnauthorizedResponse = mapper.readValue(
                new URL("file:src/test/resources/service/unauthorized_users_response.json"),
                new TypeReference<List<UnauthorizedUser>>() {}
        );
        List<UnauthorizedUser> actualUnauthorizedResponse = suspiciousEventsService.getUnauthorizedRequests("\"isAuthorized\": true", 3);

        assertNotNull(expectedUnauthorizedResponse, "Expected unauthorized response should not be null");
        assertNotNull(actualUnauthorizedResponse, "Actual unauthorized response should not be null");

        assertEquals(
                mapper.readTree(mapper.writeValueAsString(expectedUnauthorizedResponse)),
                mapper.readTree(mapper.writeValueAsString(actualUnauthorizedResponse)),
                "Expected and actual responses do not match"
        );
    */}
}
