package Selenium.codingParctice;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class DuplicateElementInArray {

    public static void main(String[] args) {

    //    int a[] = {3,2,5,1,4,2,3,6,1,4,8};

        int[] a = {3, 2, 5, 1, 4, 2, 3, 3, 4, 2, 3, 6, 6, 1, 4, 8};

        LinkedHashSet<Integer> hset = new LinkedHashSet<>();

//        for (int i =0; i<a.length; i++){
//
//            if (hset.add(a[i])==false){
//
//                System.out.print(a[i] + " ");
//            }
//
//        }

        for(int num : a){
            hset.add(num);
        }

        System.out.println(hset);

    }

}
