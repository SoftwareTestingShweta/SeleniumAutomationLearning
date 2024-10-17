package Selenium.javaPrograms;

public class NumbersAndCharInString {

    public static void main(String[] args) {

        String s = "5454gcdhsd45vf54sdbfjh";
        String n="";
        String c = "";
        int count = 0;

        for (int i =0; i< s.length();i++){
            count++;

            if (Character.isDigit(s.charAt(i)))
            {
                n= n+s.charAt(i);
            }else {
                c=c+s.charAt(i);
            }
        }

        System.out.println(n);
        System.out.println(c);
        System.out.println(count);
    }

}
