import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1339 {
    static class Alphabet implements Comparable<Alphabet>{
        int cnt, radix;
        char c;

        Alphabet(char c){
            this.c = c;
        }

        @Override
        public int compareTo(Alphabet o) {
            return radix == o.radix ? o.cnt - cnt
                    : o.radix - radix;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];
        Map<Character, Alphabet> cMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
            for (int j = 0; j < inputs[i].length(); j++) {
                char c = inputs[i].charAt(j);
                cMap.computeIfAbsent(inputs[i].charAt(j), a -> new Alphabet(c));
                Alphabet a = cMap.get(c);
                a.cnt++;
                a.radix = a.radix + (int)Math.pow(10, inputs[i].length() - j);
            }
        }

        Queue<Alphabet> pq = new PriorityQueue<>();
        for(Alphabet a : cMap.values()){
            pq.offer(a);
        }

        int[] nums = new int[100];
        int n = 9;
        while(!pq.isEmpty()){
            Alphabet a = pq.poll();
            nums[a.c] = n--;
        }

        StringBuilder[] sbs = new StringBuilder[N];
        for (int i = 0; i < inputs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0; i < inputs.length; i++) {
            String s = inputs[i];
            for (int j = 0; j < s.length(); j++) {
                sbs[i].append(nums[s.charAt(j)]);
            }
        }

        int sum = 0;
        for (StringBuilder sb : sbs) {
            sum += stoi(sb.toString());
        }
        System.out.println(sum);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
