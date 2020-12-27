package baekjoon.정렬;

import java.util.Scanner;

public class P2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        int[] a = new int[numbers];

        int i;
        for(i = 0; i < numbers; i++){
            a[i] = sc.nextInt();
        }

        int min;
        int temp;
        for(i = 0; i < numbers; i++){
            min = 1001;
            for(int j = i; j < numbers; j++){
                if(a[j] < min) min = a[j];
            }

            for(int j = i; j < numbers; j++){
                if(a[j] == min){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for(int j : a){
            System.out.println(j);
        }
    }
}
