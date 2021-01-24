package baekjoon.순열;

// n과 m (1)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {
    static int n;
    static int r;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        arr = new int[r];
        visited = new boolean[n + 1];
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
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}