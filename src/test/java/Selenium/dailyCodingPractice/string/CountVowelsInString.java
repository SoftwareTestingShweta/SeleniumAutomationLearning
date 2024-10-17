package Selenium.dailyCodingPractice.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountVowelsInString {

    public static void main(String[] args) {

        String s= "Shweta is a lucky girl and she is happily working in her dream company";
        s=s.toLowerCase();
        int count =0;

        List<Character> charList = new ArrayList<>();

        for (Character c : s.toCharArray()){

            if(c != ' ' && (c=='a' || c== 'e'||c=='i'|| c=='o'|| c=='u')){
                charList.add(c);
                count =count+1;
            }
        }

        System.out.println(count);

        List<Character> countChar = new ArrayList<>();

        for (Character a : charList){
            if (!countChar.contains(a)){
                int frequency = Collections.frequency(charList,a);
                System.out.println(a+"-"+frequency);
                countChar.add(a);
            }
        }

    }


}
