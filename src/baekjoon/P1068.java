import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1068 {

    static class Node{
        int pno;
        Set<Integer> childSet = new HashSet<>();
    }

    static Node[] tree;
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        tree = new Node[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = new Node();
        }

        for (int i = 0; i < N; i++) {
            int pno = stoi(st.nextToken());
            if(pno == -1){
                root = i;
                continue;
            }
            tree[i].pno = pno;
            tree[pno].childSet.add(i);
        }

        int dno = stoi(br.readLine());
        if(root == dno) {
            System.out.println(0);
            return;
        }

        tree[tree[dno].pno].childSet.remove(dno);
        delete(dno);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i] != null){
                if(tree[i].childSet.size() == 0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void delete(int n){
        for (int i : tree[n].childSet) {
            delete(i);
        }
        tree[n] = null;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
