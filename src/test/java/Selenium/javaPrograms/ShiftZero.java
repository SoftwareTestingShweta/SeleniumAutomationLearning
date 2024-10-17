package Selenium.javaPrograms;

import java.util.Arrays;

public class ShiftZero {

    public static void main(String[] args) {

        int[] i = {1,2,0,5,0,5,0,0,2,3,2,5,0,1,0,1};

        Arrays.sort(i);

        for (int x : i)
        {
            System.out.println(x );
        }

    }
}
