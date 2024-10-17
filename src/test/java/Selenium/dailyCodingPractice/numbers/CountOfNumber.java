package Selenium.dailyCodingPractice.numbers;

public class CountOfNumber {

    public static void main(String[] args) {

        int no = 1234568;
        int rev;
        int count = 0;

        while(no != 0){

            rev = no%10;
            count =count +1;
            no = no/10;

        }
        System.out.println(count);
    }
}
