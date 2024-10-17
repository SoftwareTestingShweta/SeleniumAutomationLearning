package Selenium.codingParctice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharOccurance {

    public static void main(String[] args) {

        String s = "Shweta is a very lucky girl";
        s = s.toLowerCase();

        List<Character> charList = new ArrayList<>();

        for (Character c :s.toCharArray()){
            if(c != ' '){
                charList.add(c);
            }
        }

        System.out.println(charList);

        List<Character> countChar = new ArrayList<>();

        for (Character a : charList){
            if(!countChar.contains(a)){

                int frequency = Collections.frequency(charList,a);
                System.out.println(a+" -" +frequency);
                countChar.add(a);
            }
        }

    }

}
