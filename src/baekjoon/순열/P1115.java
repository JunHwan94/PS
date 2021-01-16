package baekjoon.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 순열
// 풀이중
public class P1115 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] a = new int[len];

        StringTokenizer token = new StringTokenizer(br.readLine());

        // base 정의
        for(int i = 0; i < len; i++){
            a[i] = Integer.parseInt(token.nextToken());
        }

        getPermutation(a, 0);

        int[] b = new int[len];
        b[0] = 0;
        // b 정의
        for(int i = 1; i < len; i++){
            b[i] = a[b[i-1]];
        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

//        System.out.println(fac(4));
    }

    public static int fac(int i){
        if(i == 1)
            return 1;
        else
            return i * fac(i - 1);
    }

    public static void getPermutation(int[] arr, int startIdx){
        int length = arr.length;
        int[] b = new int[length];
        Set<Integer> bSet = new HashSet<>();
        b[0] = 0;
        for(int i = 1; i < length; i++){
            b[i] = arr[b[i]];
            bSet.add(b[i]);
        }
        System.out.println(Arrays.toString(b));
        if(bSet.size() != b.length) {
            System.out.println("b는 완벽한 순열이 아님");
        }else System.out.println("b는 완벽한 순열");

        if(startIdx == length - 1){
            for(int n: arr) System.out.print(n + " ");
            System.out.println();
            return;
        }

        for(int i = startIdx; i < length; i++){
            swap(arr, startIdx, i);
            getPermutation(arr, startIdx + 1);
            swap(arr, startIdx, i);
        }
    }

    public static void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
