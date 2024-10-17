package Selenium.dailyCodingPractice.numbers;

import java.util.HashSet;

public class FindLargestArray {

    public static void main(String[] args) {

        int a[] = {20,50,6,0,41,10,20,30,25,40,60,30,10,45};
        int size = a.length;
        int sum =50;

        HashSet<Integer> hset = new HashSet<>();

        for (int i=0;i<size;i++){
            if(hset.add(a[i])==false){
                System.out.print(a[i]+" ");
            }
        }


    }
}
