import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1504 {
    static class Edge implements Comparable<Edge>{
        int to, dist;

        Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int E = stoi(st.nextToken());
        List<Edge>[] adjLists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int dist = stoi(st.nextToken());
            adjLists[from].add(new Edge(to, dist));
            adjLists[to].add(new Edge(from, dist));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = stoi(st.nextToken());
        int v2 = stoi(st.nextToken());

        Queue<Edge> pq = new PriorityQueue<>();
        int[] d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;

        pq.offer(new Edge(1, 0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.to;
            int cDist = e.dist;
            for (Edge ne : adjLists[cur]) {
                int next = ne.to;
                int nDist = ne.dist;
                if(d[next] > cDist + nDist){
                    d[next] = cDist + nDist;
                    pq.offer(new Edge(next, d[next]));
                }
            }
        }

        int[] d1 = new int[N + 1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        d1[v1] = 0;

        pq.offer(new Edge(v1, 0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.to;
            int cDist = e.dist;
            for (Edge ne : adjLists[cur]) {
                int next = ne.to;
                int nDist = ne.dist;
                if(d1[next] > cDist + nDist){
                    d1[next] = cDist + nDist;
                    pq.offer(new Edge(next, d1[next]));
                }
            }
        }

        int[] d2 = new int[N + 1];
        Arrays.fill(d2, Integer.MAX_VALUE);
        d2[v2] = 0;

        pq.offer(new Edge(v2, 0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.to;
            int cDist = e.dist;
            for (Edge ne : adjLists[cur]) {
                int next = ne.to;
                int nDist = ne.dist;
                if(d2[next] > cDist + nDist){
                    d2[next] = cDist + nDist;
                    pq.offer(new Edge(next, d2[next]));
                }
            }
        }

        long min1 = d[v1] + d1[v2] + d2[N];
        if(d[v1] == Integer.MAX_VALUE || d1[v2] == Integer.MAX_VALUE || d2[N] == Integer.MAX_VALUE){
            min1 = Integer.MAX_VALUE;
        }
        long min2 = d[v2] + d2[v1] + d1[N];
        if(d[v2] == Integer.MAX_VALUE || d2[v1] == Integer.MAX_VALUE || d1[N] == Integer.MAX_VALUE){
            min2 = Integer.MAX_VALUE;
        }
        long min = Math.min(min1, min2);
        if(min >= Integer.MAX_VALUE){
            min = -1;
        }
        System.out.println(min);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
