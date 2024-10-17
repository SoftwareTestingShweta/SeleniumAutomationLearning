package Selenium.dailyCodingPractice.numbers;

public class FindGivenSumOfArray {

    public static void main(String[] args) {

        int []a = {10,20,60,30,40,81,85,30,25,30,25,20,40};

        int sum = 50;

        for (int i=0; i<a.length;i++){
            for (int j=i+1; j<a.length; j++){


                if(a[j] == sum-a[i]){
                    System.out.println(a[i] + " "+ a[j]);
                }

            }
        }


    }
}
