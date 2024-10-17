package Selenium.codingParctice;

public class RemoveSpaceFromString {

    public static void main(String[] args) {

        String s = "This_Is_My_String";

        String s1 = new String(s.replaceAll("_"," "));
        System.out.println(s1);

    }
}
