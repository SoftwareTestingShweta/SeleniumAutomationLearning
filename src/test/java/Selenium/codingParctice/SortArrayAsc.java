package Selenium.codingParctice;

public class SortArrayAsc {

    public static void main(String[] args) {

        int a[] = {5,2,4,3,6,9,7,1,4};
        int size =a.length;
        int temp;

        for (int i=0;i<size;i++){

            for (int j =i+1; j<size;j++){

                if (a[i]<a[j]){

                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

            }
        }
        for (int i=0; i<size;i++){
            System.out.print(a[i] + " ");
        }

        System.out.println("************" + a[size-1]);
    }
}
