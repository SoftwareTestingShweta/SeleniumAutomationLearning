package Selenium.codingParctice;

public class PrimeNo {

    public static void main(String[] args) {

        int no = 11;
        int count = 0;

        for (int i =1; i<=no; i++){

            if (no%i==0) {
                count = count + 1;
            }
        }
        if(count==2){
            System.out.println("prime no");
        }
        else {
            System.out.println("not prime");
        }
    }
}
