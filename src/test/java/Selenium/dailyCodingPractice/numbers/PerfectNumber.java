package Selenium.dailyCodingPractice.numbers;

public class PerfectNumber {

    public static void main(String[] args) {

        int no = 28;
        int temp=no;
        int rev = 0;

        for (int i=1;i<no;i++) {

            if (no % i == 0) {
                rev = rev + i;
            }
        }
        if(rev==temp){
            System.out.println("perfect no");
        }
        else {
            System.out.println("not");
        }
    }
}
