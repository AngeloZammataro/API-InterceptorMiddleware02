package it.develhope.Angelo.API.InterceptorMiddleware02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    //welcomes the user on the root mapping
    @GetMapping("")
    private String sayWelcome(){
        return "Welcome in myPage";
    }
}
