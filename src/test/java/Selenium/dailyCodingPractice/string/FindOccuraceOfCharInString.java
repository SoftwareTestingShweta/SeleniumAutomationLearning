package Selenium.dailyCodingPractice.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindOccuraceOfCharInString {

    public static void main(String[] args) {

        String s = "Shweta is a lucky girl";
        s=s.toLowerCase();

        List<Character> charList = new ArrayList<>();

        for(Character c : s.toCharArray()){
            if (c != ' '){
                charList.add(c);
            }
        }

        System.out.println(charList);

        List<Character> countedChar = new ArrayList<>();

        for (Character a : charList){

            if(!countedChar.contains(a)){

                int frequency = Collections.frequency(charList, a);
                System.out.println(a + "-" + frequency);
                countedChar.add(a);

            }

        }




    }
}
