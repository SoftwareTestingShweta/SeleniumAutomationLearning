package Selenium.dailyCodingPractice.numbers;

import java.util.HashSet;

public class FindDuplicateNoInArray {

    public static void main(String[] args) {

        int a[] = {2,5,2,6,4,5,3,8,1,3,9,7};

        HashSet<Integer> hset = new HashSet<>();

        for (int i=0;i<a.length;i++){
            if(hset.add(a[i])==false){
                System.out.print(a[i]+" ");
            }
        }

    }

}
