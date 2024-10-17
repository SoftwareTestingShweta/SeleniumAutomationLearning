package Selenium.codingParctice;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharInString {

    public static void main(String[] args) {

        String s = "coconut";

        Set<Character> set = new LinkedHashSet<>();

        for (int i=0; i<s.length(); i++){

            set.add(s.charAt(i));

        }

        StringBuffer sb = new StringBuffer();

        for (Character c : set){

            sb.append(c);
        }

        System.out.println(sb);
    }


}
