package Selenium.dailyCodingPrac2.string1;

import java.util.ArrayList;
import java.util.List;

public class CountVowelsAndCosonent {

    public static void main(String[] args) {

        String s = "Shweta is a lucky girl";
        s=s.replaceAll(" ","").toLowerCase();
        int vowels = 0;
        int consonant = 0;

        for (int i=0; i<s.length();i++){
            char ch = s.charAt(i);

            if(ch>='a' && ch<='z'){

                if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    vowels =vowels+1;
                }
                else {
                    consonant= consonant+1;
                }
            }
        }

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonant);

    }
}
