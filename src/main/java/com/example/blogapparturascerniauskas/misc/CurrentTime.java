package com.example.blogapparturascerniauskas.misc;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
    public static String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
