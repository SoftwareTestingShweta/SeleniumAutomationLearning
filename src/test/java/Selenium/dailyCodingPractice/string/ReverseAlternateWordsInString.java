package Selenium.dailyCodingPractice.string;

public class ReverseAlternateWordsInString {

    public static void main(String[] args) {

        String s = "Shweta is lucky girl";
        String words[] = s.split(" ");

        // Reversing from starting word

//        for (int i=0;i<words.length;i=i+2){
//            words[i] = new StringBuilder(words[i]).reverse().toString();
//        }
//
//        System.out.println(s.join(" ",words));

        System.out.println("********************************************");
        // Reversing from 2nd word

        for (int j=1; j< words.length;j=j+2){
            words[j] = new StringBuilder(words[j]).reverse().toString();
        }

        System.out.println(String.join(" ",words));

    }

}
