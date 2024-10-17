package Selenium.codingParctice;

public class SperateCharAndNumFromString {

    public static void main(String[] args) {

        String s = "ds4g54s6gsdgsdb654654ds4h5gthbfg5456";
        String n ="";
        String c ="";

        for (int i=0; i<s.length();i++){

            if (Character.isDigit(s.charAt(i))){
                n= n + (s.charAt(i));
            }
            else {
                c = c + (s.charAt(i));
            }

        }

        System.out.println("Numbers "+ n);
        System.out.println("Characters "+ c);




    }


}
