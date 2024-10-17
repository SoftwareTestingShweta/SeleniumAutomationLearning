package Selenium.javaPrograms;

public class ReverseArray {

    public static void main(String[] args) {

        int [] i = {1,2,3,4,5,6};

        for (int j = i.length-1; j>=0 ; j--) {
            System.out.println(i[j]);
        }

    }
}
