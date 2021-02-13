package baekjoon.완전탐색.순열;
// n과 m (3)
import java.io.*;
import java.util.StringTokenizer;

public class P15651 {
    static int n;
    static int r;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        arr = new int[r];
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

        for(int i = 1; i <= n; i++){
                arr[depth] = i;
                permutation(depth + 1);
        }
    }
}