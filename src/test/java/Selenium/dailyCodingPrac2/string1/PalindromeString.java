package Selenium.dailyCodingPrac2.string1;

public class PalindromeString {
    public static void main(String[] args) {

        String s ="madaam";
        int size =s.length();
        String rev="";

        for (int i=size-1;i>=0;i--){
            rev = rev + s.charAt(i);
        }
        if (rev.equals(s)){
            System.out.println("Palindrome String");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }
}
