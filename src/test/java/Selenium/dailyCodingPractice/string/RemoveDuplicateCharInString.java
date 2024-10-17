package Selenium.dailyCodingPractice.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharInString {

    public static void main(String[] args) {

        String s = "coconut";
        int size = s.length();

        Set<Character> set = new LinkedHashSet<>();

        for(int i =0; i<size;i++){

            set.add(s.charAt(i));
        }

        StringBuffer sb = new StringBuffer();

        for(Character c : set){
            sb.append(c);
        }

        System.out.println(sb);
    }

}
