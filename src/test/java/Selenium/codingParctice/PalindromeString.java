package Selenium.codingParctice;

public class PalindromeString {

    public static void main(String[] args) {

        String s = "madamm";
        int a = s.length();
        String rev="";

        for (int i=a-1;i>=0;i--){

            rev = rev+s.charAt(i);

        }
        if (rev.equals(s)){
            System.out.println("palindrome string");
        }
        else {
            System.out.println("not palindrome");
        }

    }

}
