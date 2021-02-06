package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1697 {
    static int n;
    static int k;
    static Set<Integer> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        bfs();
        System.out.println(st);
    }

    static int st;
    static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(n, 0));
        visited.add(n);
        while(!q.isEmpty()){
            int pos = q.peek().pos;
            if(pos == k) {
                st = q.poll().t;
                break;
            }
            int t = q.poll().t;

            for(int i = 0; i < 3; i++) {
                int np = pos;
                switch(i){
                    case 0: np -= 1; break;
                    case 1: np += 1; break;
                    case 2: np *= 2; break;
                }
                if(np < 0 || visited.contains(np)) continue;
                if(k < pos && pos < np) continue;
                q.offer(new Pair(np, t + 1));
                visited.add(np);
            }
        }
    }

    static class Pair{
        int pos;
        int t;
        Pair(int pos, int t){
            this.pos = pos;
            this.t = t;
        }
    }
}
