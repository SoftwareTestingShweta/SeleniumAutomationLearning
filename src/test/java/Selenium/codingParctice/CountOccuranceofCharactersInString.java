package Selenium.codingParctice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOccuranceofCharactersInString {
    public static void main(String[] args) {

        String s = "Iris Software opened in Pune";
        s = s.toLowerCase();

        List<Character> listChar = new ArrayList<>();

        for (char c : s.toCharArray()){

            if (c != ' '){
                listChar.add(c);
            }
        }

        System.out.println(listChar);

        List<Character> countChar = new ArrayList<>();

        for(char a : listChar){

            if (!countChar.contains(a)){

                int frequency = Collections.frequency(listChar,a);
                System.out.println(a +" - " + frequency);
                countChar.add(a);

                }
            }

        }


}
