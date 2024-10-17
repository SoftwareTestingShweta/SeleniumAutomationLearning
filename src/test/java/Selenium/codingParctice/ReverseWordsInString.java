package Selenium.codingParctice;

public class ReverseWordsInString {

    public static void main(String[] args) {

        String s = "Shweta is very lucky girl";

        String words[] = s.split(" ");

        for (int i=0; i<words.length;i=i+2){

            words[i] = new StringBuilder(words[i]).reverse().toString();

        }

        System.out.println(String.join(" ",words));

    }


}
