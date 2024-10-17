package Selenium.javaPrograms;

import java.util.Scanner;

public class AmstrongNumber {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask the user for input
        System.out.print("Enter a number: ");
        int no = scanner.nextInt();
       int temp = no;
       int rev = 0;
       int rem;

       while(no!=0){

           rem = no%10;
           rev = rev +(rem*rem*rem);
           no = no/10;

       }

       if (temp == rev){
           System.out.println("amstrong no");
       }else {
           System.out.println("not");
       }
    }
}
