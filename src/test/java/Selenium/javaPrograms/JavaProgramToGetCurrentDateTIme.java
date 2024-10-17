package Selenium.javaPrograms;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaProgramToGetCurrentDateTIme {

    public static void main(String[] args) {

        Date now = new Date();

        // Get the current date/time
//        LocalDateTime now = LocalDateTime.now();
//
//        // Format the date/time using the desired pattern
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedDateTime = now.format(formatter);
//
//        // Print the formatted date/time
//        System.out.println("Current date/time: "+ formattedDateTime);

        // ISO 8601
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println("ISO 8601: " + isoFormat.format(now));

    }

}
