package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16235 {
    static int N, M, K;
    static int[][] area, fqtt;
    static Queue<Integer>[][] trees;
    static Queue<Integer> deadTrees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        area = new int[N + 1][N + 1];
        trees = new Queue[N + 1][N + 1];
        fqtt = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(area[i], 5);
            for (int j = 1; j <= N; j++) {
                trees[i][j] = new PriorityQueue<>();
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                fqtt[i][j] = stoi(st.nextToken());
            }
        }

        // 나무 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int z = stoi(st.nextToken());
            trees[x][y].offer(z);
        }

        for (int i = 0; i < K; i++) {
            deadTrees = new ArrayDeque<>();
            spring();
            summer();
            autumn();
            winter();
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                cnt += trees[i][j].size();
        System.out.println(cnt);
    }

    private static void winter() {
        // 양분 추가
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                area[i][j] += fqtt[i][j];
            }
        }
    }

    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1 ,-1};
    private static void autumn() {
        // 번식
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int k = 0; k < 8; k++) {
                            int xx = i + dx[k];
                            int yy = j + dy[k];
                            if (xx < 1 || xx > N || yy < 1 || yy > N) continue;
                            trees[xx][yy].offer(1);
                        }
                    }
                }
            }
        }
    }

    private static void summer() {
        while(!deadTrees.isEmpty()){
            int x = deadTrees.poll();
            int y = deadTrees.poll();
            int food = deadTrees.poll();
            area[x][y] += food;
        }
    }

    public static void spring(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Queue<Integer> q = new PriorityQueue<>();
                while(!trees[i][j].isEmpty()) {
                    // 남은양분 = 양분 - 나무나이
                    int remain = area[i][j] - trees[i][j].peek();
                    // 양분이 부족하면 즉시 죽음.
                    if(remain < 0) {
                        deadTrees.offer(i);
                        deadTrees.offer(j);
                        deadTrees.offer(trees[i][j].poll() / 2);
                    }else {
                        // 나무나이 + 1
                        q.offer(trees[i][j].poll() + 1);
                        area[i][j] = remain;
                    }
                }
                trees[i][j] = q;
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
