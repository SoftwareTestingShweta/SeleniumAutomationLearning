package Selenium.dailyCodingPrac2.string1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharInString {
    public static void main(String[] args) {

        String s = "coconut";

        Set<Character> set = new LinkedHashSet<>();

        for (int i=0; i<s.length();i++){
            set.add(s.charAt(i));
        }

        System.out.println(set);

        StringBuilder sb = new StringBuilder();

        for (char c : set){
            sb.append(c);
        }

        System.out.println(sb);
    }
}
