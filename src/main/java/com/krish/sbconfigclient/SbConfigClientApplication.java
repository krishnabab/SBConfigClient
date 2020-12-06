package com.krish.sbconfigclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@RestController
public class SbConfigClientApplication {

    @Value("${user.email}")
    public String email;
    @Value("${location}")
    public String location;

    public static void main(String[] args) {

        SpringApplication.run(SbConfigClientApplication.class, args);
    }

    @GetMapping(
            value = "/email/{username}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello!You're %s and your assigned email is %s...\n and your location is %s", username, email,location);
    }
}
