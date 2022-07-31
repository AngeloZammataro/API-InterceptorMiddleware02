package it.develhope.Angelo.API.InterceptorMiddleware02.interceptors;

import it.develhope.Angelo.API.InterceptorMiddleware02.entities.Month;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    //has a list of 6 Months
    public static List<Month> months = new ArrayList<>(Arrays.asList(
       new Month(1,"Gennaio","January","Januar"),
       new Month(2,"Febbario","February","Februar"),
       new Month(3,"Marzo","March","Marsch"),
       new Month(4,"Aprile","April","April"),
       new Month(5,"Maggio","May","Kann"),
       new Month(6,"Giugno","June","Juni")
    ));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if (monthNumberString == null){
            return true;
        }
        int monthNumber = Integer.parseInt(monthNumberString);
        Optional<Month> month = months.stream().filter(SingleMonth ->{
            return SingleMonth.getMonthNumber() == monthNumber;
        }).findAny();

        if(month.isPresent()){
            request.setAttribute("month",month.get());
        }
        return true;
    }
}
