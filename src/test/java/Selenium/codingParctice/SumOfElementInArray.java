package Selenium.codingParctice;

public class SumOfElementInArray {

    public static void main(String[] args) {

        int a[] = {10,60,50,40,20,10,30,10,20,40};

        int sum = 50;
        int size = a.length;

        for (int i=0; i<size; i++){

            for (int j=i+1; j<size;j++){

                if (a[j] == sum-a[i]){

                    System.out.println(a[i]+","+a[j]);
                }

            }

        }


    }


}
