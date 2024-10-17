package Selenium.dailyCodingPrac2.string1;

public class ReverseString {

    public static void main(String[] args) {

        String s = "shweta";
        int size=s.length();
        String rev = "";

        for (int i=size-1;i>=0;i--){
            rev = rev + s.charAt(i);

        }

        System.out.println(rev);

    }



}
