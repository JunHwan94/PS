import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int[] tree = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = stoi(st.nextToken());
        }

        int dNode = stoi(br.readLine());
        Set<Integer> set = new HashSet<>();
        set.add(dNode);
        boolean[] isNotLeafArr = new boolean[N];
        isNotLeafArr[dNode] = true;
        for (int i = 0; i < N; i++) {
            if(set.contains(tree[i])){
                set.add(i);
                isNotLeafArr[i] = true;
            }
        }

        for (int i : set) {
            tree[i] = -2;
        }

        for (int i = 0; i < N; i++) {
            if(tree[i] >= 0) {//!= -2) {
                isNotLeafArr[tree[i]] = true;
            }
        }

        int cnt = 0;
        for (boolean isNotLeaf : isNotLeafArr) {
            if(!isNotLeaf){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
