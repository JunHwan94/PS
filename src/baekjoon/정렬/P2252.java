package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2252 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        // 노드 초기화
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new Node();
        }

        // 전, 후 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = stoi(st.nextToken());
            int next = stoi(st.nextToken());
            nodes[prev].nextNodes.add(next); // 다음 번호 저장
            nodes[next].inCount++; // 다음노드가 받는 이전 노드 갯수 증가
        }

        int count = nodes.length - 1; // 출력해야하는 노드 갯수
        StringBuilder sb = new StringBuilder();
        while(count > 0){
            for (int prev = 1; prev < N + 1; prev++) {
                // null이 아니고 inCount가 0이면 출력하기
                if(nodes[prev] != null && nodes[prev].inCount == 0) {
                    sb.append(prev).append(" ");
                    // 다음 노드의 inCount 감소
                    for (int next : nodes[prev].nextNodes) {
                        nodes[next].inCount--;
                    }

                    // 출력한 노드는 null로
                    nodes[prev] = null;
                    count--;
                }
            }
        }
        System.out.println(sb);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }

    static class Node{
        int inCount = 0;
        List<Integer> nextNodes = new ArrayList<>();
    }
}