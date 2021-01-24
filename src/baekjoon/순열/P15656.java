package baekjoon.순열;
// n과 m (7)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P15656 {
    static int n;
    static int r;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        arr = new int[r];

        token = new StringTokenizer(br.readLine());
        while(token.hasMoreTokens())
            list.add(Integer.parseInt(token.nextToken()));
        Collections.sort(list);
        permutation(0);
        System.out.println(sb.toString());
    }

    static void permutation(int depth){
        if(depth == r){
            for(int i = 0; i < r; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < list.size(); i++){
            arr[depth] = list.get(i);
            permutation(depth + 1);
        }
    }
}