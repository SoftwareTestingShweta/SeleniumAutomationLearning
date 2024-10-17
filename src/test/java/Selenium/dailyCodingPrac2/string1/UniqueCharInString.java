package Selenium.dailyCodingPrac2.string1;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class UniqueCharInString {

    public static void main(String[] args) {

        String s = "Shweta is a very lucky girl and she is very positive";
        s=s.replaceAll(" ","").toLowerCase();
        int count=0;

        HashSet<Character> hset = new LinkedHashSet<>();

        for (int i=0;i<s.length();i++){
          if(hset.add(s.charAt(i))) {
              count = count + 1;
          }
        }
        System.out.println(hset);
        System.out.println(count);
    }
}
