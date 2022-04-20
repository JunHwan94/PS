package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1707 {

    static int V, E;
    static List<List<Integer>> graph;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = stoi(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = stoi(st.nextToken());
            E = stoi(st.nextToken());
            graph = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean isBG = false;
            numbers = new int[V + 1];
            for (int j = 1; j <= V; j++) {
                if(numbers[j] == 0) {
                    setNumbers(j);
                    isBG = checkBipartiteGraph();
                    if (!isBG) {
                        break;
                    }
                }
            }
            if(isBG){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    static void setNumbers(int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        numbers[n] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if(numbers[next] == 0){
                    if(numbers[cur] == 1) {
                        numbers[next] = 2;
                    }else if(numbers[cur] == 2){
                        numbers[next] = 1;
                    }
                    q.offer(next);
                }
            }
        }
    }

    static boolean checkBipartiteGraph(){
        for (int cur = 1; cur <= V; cur++) {
            for (int next : graph.get(cur)) {
                if(numbers[cur] > 0 && numbers[cur] == numbers[next]) {
                    return false;
                }
            }
        }
        return true;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}