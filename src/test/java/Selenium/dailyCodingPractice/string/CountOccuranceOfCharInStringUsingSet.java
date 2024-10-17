package Selenium.dailyCodingPractice.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CountOccuranceOfCharInStringUsingSet {

    public static void main(String[] args) {

        String s = "Shweta is a lucky girl";
        s=s.toLowerCase();

        Set<Character> charSet = new HashSet<>();

        for (Character c : s.toCharArray()){
            if(c != ' '){
                charSet.add(c);
            }
        }

        System.out.println(charSet);

        Set<Character> countedSet = new HashSet<>();

        for(Character a : charSet){
            if(!countedSet.contains(a)){

                int frequency = Collections.frequency(charSet, a);
                System.out.println(a+"-"+frequency);
                countedSet.add(a);
            }
        }

    }

}
