package Selenium.dailyCodingPractice.numbers;

public class AmstrongNumber {

    public static void main(String[] args) {

        int no =153;
        int temp=no;
        int rem;
        int rev=0;

        while(no!=0){

            rem=no%10;
            rev= rev + (rem*rem*rem);
            no=no/10;
        }

        if (rev==temp){
            System.out.println("Amstrong no");
        }
        else {
            System.out.println("not");
        }
    }
}
