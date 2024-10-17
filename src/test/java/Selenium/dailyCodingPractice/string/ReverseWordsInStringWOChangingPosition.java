package Selenium.dailyCodingPractice.string;

public class ReverseWordsInStringWOChangingPosition {

    public static void main(String[] args) {

        String s = "Shweta is lucky girl";

        String words[] = s.split(" ");

        for (int i =0; i<words.length;i++){

            words[i] = new StringBuilder(words[i]).reverse().toString();

        }

        System.out.println(String.join(" ",words));


    }

}
