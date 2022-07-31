package it.develhope.Angelo.API.InterceptorMiddleware02.controllers;

import it.develhope.Angelo.API.InterceptorMiddleware02.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/months")
public class MonthController {
/*
    //returns a Month using a specific request attribute
    @GetMapping("/months")
    public Month getMonth(Month month){
        return new Month(1,"August","Agosto","August");
    }
*/
    @GetMapping("")
    public Month getMonth(HttpServletRequest request){
        Month month = (Month) request.getAttribute("month");
        return month;
    }
}
