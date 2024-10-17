package Selenium.dailyCodingPractice.numbers;

import java.util.HashSet;

public class PrimeNumber {

    public static void main(String[] args) {

        int no = 8;
        int count = 0;

        for (int i=1; i<=no;i++){

            if(no%i==0){
                count=count+1;
            }
        }
        if(count==2){
            System.out.println("prime no");
        }
        else {
            System.out.println("not");
        }

    }

}
