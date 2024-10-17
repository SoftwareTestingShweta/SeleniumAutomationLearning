package Selenium.dailyCodingPractice.numbers;

public class FindSecondLargestElementInArray {

    public static void main(String[] args) {

        int a[] = {2,5,7,6,9,14,6,3,8};
        int size = a.length;
        int temp;

        for (int i=0; i<size;i++){
            for (int j = i+1; j<size;j++){

                if(a[i]>a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for(int c : a){
            System.out.print(c + ",");
        }

       System.out.println(a[size-2]);

    }

}
