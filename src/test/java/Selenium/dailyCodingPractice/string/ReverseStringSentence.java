package Selenium.dailyCodingPractice.string;

public class ReverseStringSentence {

    public static void main(String[] args) {

        String s = "Shweta is very lucky girl";

        String a [] = s.split(" ");

        StringBuilder reversedSentence = new StringBuilder();

        for (int i=a.length-1;i>=0;i--){

            reversedSentence.append(a[i]);

            if (i != 0) {
                reversedSentence.append(" ");
            }

        }

        System.out.println(reversedSentence.toString());

    }
}
