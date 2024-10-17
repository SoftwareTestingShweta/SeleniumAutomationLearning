package Selenium.dailyCodingPractice.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountOfUniqueCharInString {

    public static void main(String[] args) {

        String s= "Shweta is a lucky girl and she is happily working in her dream company";
        s=s.replaceAll(" ","").toLowerCase();

        Set<Character> hset = new HashSet<>();

        for(int i =0; i<s.length()-1;i++){

            char c = s.charAt(i);
            hset.add(c);

        }
        System.out.println(hset);
        System.out.println(hset.size());

    }

}
