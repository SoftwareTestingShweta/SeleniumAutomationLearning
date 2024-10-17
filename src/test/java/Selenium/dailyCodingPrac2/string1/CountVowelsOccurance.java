package Selenium.dailyCodingPrac2.string1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountVowelsOccurance {
    public static void main(String[] args) {

        String s = "Shweta is a very lucky girl and she is very positive";
        s=s.replaceAll(" ","").toLowerCase();
        int vowels=0;

        List<Character> charList = new ArrayList<>();

        for (Character c : s.toCharArray()){
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                charList.add(c);
                vowels = vowels+1;
            }
        }

        System.out.println(charList);
        System.out.println(vowels);


        List<Character> countChar = new ArrayList<>();

        for (Character a :charList){
            if (!countChar.contains(a)){
                int frequency = Collections.frequency(charList,a);
                System.out.println(a+","+frequency);
                countChar.add(a);
            }
        }


    }
}
