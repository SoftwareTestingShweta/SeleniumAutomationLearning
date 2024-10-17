package Selenium.dailyCodingPractice.string;

public class ReverseSentenceInString {

    public static void main(String[] args) {

        String s = "Shweta is a lucky girl";
         String a[] = s.split(" ");

         StringBuilder sb  = new StringBuilder();

         for (int i=a.length-1; i>=0;i--){
             sb.append(a[i]);

             if (i != 0){
                 sb.append(" ");
             }
         }

        System.out.println(sb.toString());

    }
}
