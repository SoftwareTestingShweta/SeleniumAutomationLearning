package Selenium.dailyCodingPractice.numbers;

public class AdditionOfNumbers {

    public static void main(String[] args) {

        int no = 124563;
        int sum = 0;

        while(no!=0){

            sum = sum + no%10;
            no = no/10;
        }
        System.out.println(sum);
    }
}
