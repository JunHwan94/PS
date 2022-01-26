package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P12764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Pair> pq = new PriorityQueue<>();
        StringTokenizer token;
        for(int i = 0; i < N; i++){
            token = new StringTokenizer(br.readLine());
            pq.offer(new Pair(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        List<Integer> cList = new ArrayList<>(); // 컴퓨터들
        List<Integer> cnts = new ArrayList<>(); // 사용한 사람 수
        while(!pq.isEmpty()){
            int start = pq.peek().start;
            int end = pq.poll().end;
            int emptyIdx = -1;
            boolean first = true;
            for(int i = 0, size = cList.size(); i < size; i++){
                // 시간 된 애는 나감
                if(cList.get(i) <= start) {
                    cList.set(i, 0); // 값을 0으로 해서 빈자리로 간주
                    if(first){
                        emptyIdx = i; // 빈자리
                        first = false;
                    }
                }
            }

            if (emptyIdx != -1) { // 빈자리 있으면 거기다 넣기
                cList.set(emptyIdx, end);
                cnts.set(emptyIdx, cnts.get(emptyIdx) + 1);
            } else { // 빈자리 없으면 컴퓨터 1대 더하기
                cList.add(end);
                cnts.add(1);
            }
        }
        System.out.println(cnts.size());
        for(int i = 0; i < cnts.size(); i++){
            System.out.print(cnts.get(i) + " ");
        }
    }

    static class Pair implements Comparable{
        int start, end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            return this.start - ((Pair)o).start;
        }
    }
}
