package Selenium.practiceToolsQA;

public class AdditionArary {

    public static void main(String[] args) {

        int a[] = {10,30,20,60,40,10,40};
        int sum = 50;
        int size = a.length;

        for(int i = 0;i<size;i++){

            for(int j=i+1; j<size;j++){

                if(a[j] == sum-a[i]){
                    System.out.println(a[i]+ ","+a[j]);
                }


            }

        }


    }
}
