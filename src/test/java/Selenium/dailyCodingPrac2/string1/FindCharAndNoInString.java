package Selenium.dailyCodingPrac2.string1;

public class FindCharAndNoInString {
    public static void main(String[] args) {

        String s= "sd65f4b6545gh4rtg5sh4bc5r45gs4f4354sudh";
        String c="";
        String no="";

        for (int i=0;i<s.length();i++){
            if (Character.isDigit(s.charAt(i))){

                no = no + s.charAt(i);
            }
            else {
                c= c+ s.charAt(i);
            }
        }
        System.out.println(no);
        System.out.println(c);
    }
}
