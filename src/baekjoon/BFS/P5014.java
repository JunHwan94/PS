package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class P5014 {
    static Function<String, Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int F = stoi.apply(split[0]);
        int S = stoi.apply(split[1]);
        int G = stoi.apply(split[2]);
        int U = stoi.apply(split[3]);
        int D = stoi.apply(split[4]);

        if(S == G) {
            System.out.println(0);
            return;
        }

        int[] df = {U, -D};
        int[] cnts = new int[F + 1];
        boolean[] visited = new boolean[F + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = true;
        while(!q.isEmpty()){
            int f = q.poll();
            for (int i = 0; i < 2; i++) {
                int nf = f + df[i];
                if(nf > F || nf < 1 || visited[nf]) continue;
                visited[nf] = true;
                cnts[nf] = cnts[f] + 1;
                if(nf == G){
                    System.out.println(cnts[nf]);
                    return;
                }
                q.offer(nf);
            }
        }
        System.out.println("use the stairs");
    }
}