package net.javaguides.sprintboot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    // Create the method
    public String helloWorld(){
        return "Hello world";
    }

}