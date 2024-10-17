package Selenium.javaPrograms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    public static void main(String[] args) {

        String input = "abhgababbaabab";
        int count = 0;

        Pattern p = Pattern.compile("ab");
        Matcher m = p.matcher(input);

        while (m.find()){
            count++;
            System.out.println("Found 'ab' at index: " + m.start());
        }

        System.out.println(count);
    }
}
