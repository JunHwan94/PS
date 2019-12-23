package Level1;

import java.util.*;
public class MaxMinSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] ia = new int[cnt];
        int i = 0;
        while(i < cnt){
            ia[i] = sc.nextInt();
            i++;
        }
        i = 0;
        while(i < cnt){
            int max = Integer.MIN_VALUE;
            int temp;
            int maxIdx = 0;
            int minIdx = 0;
            int min = Integer.MAX_VALUE;
            int j = i;
            while(j < cnt){
                if(max < ia[j]){
                    max = ia[j];
                    maxIdx = j;
                }
                if(min > ia[j]){
                    min = ia[j];
                    minIdx = j;
                }
                j++;
            }

            temp = ia[i];
            ia[i] = i % 2 == 0 ? max : min;
            int idx = i % 2 == 0 ? maxIdx : minIdx;
            ia[idx] = temp;

            i++;
        }
        System.out.println(Arrays.toString(ia).replace("[", "").replace("]", "").replace(", ", " "));
    }
}

