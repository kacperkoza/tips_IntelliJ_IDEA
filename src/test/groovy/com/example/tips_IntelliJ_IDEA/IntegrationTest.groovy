package com.example.tips_IntelliJ_IDEA

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.web.client.RestTemplate

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [AppRunner.class]
)
class InegrationTest {

    @LocalServerPort
    int port

    RestTemplate restTemplate = new RestTemplate()

    String localUrl(String endpoint) {
        return "http://localhost:$port$endpoint"
    }

    def 'test'() {
        expect:
        true
    }

}

