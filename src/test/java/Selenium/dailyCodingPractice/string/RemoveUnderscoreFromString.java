package Selenium.dailyCodingPractice.string;

public class RemoveUnderscoreFromString {

    public static void main(String[] args) {

        String s = "Shweta_is_lucky_girl";

        String s1 = s.replaceAll("_"," ");

        System.out.println(s1);

    }

}
