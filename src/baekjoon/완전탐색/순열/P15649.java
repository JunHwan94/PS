package baekjoon.완전탐색.순열;

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

// n과m(1)

//public class Main {
//    static int n, m;
//    static boolean[] visit;
//    static Stack<Integer> stack = new Stack<>();
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        visit = new boolean[n];
//        solve(0);
//    }
//
//    public static void solve(int cnt) {
//        if(cnt == m ) {
//            for(int x : stack) {
//                System.out.print(x+1 + " ");
//            }
//            System.out.println();
//            return ;
//        }
//        for(int i=0; i<n; i++) {
//            if (!visit[i]) {
//                visit[i] = true;
//                stack.push(i);
//                solve(cnt+1);
//                stack.pop();
//                visit[i] = false;
//            }
//        }
//        return;
//    }
//}