package baekjoon.문자열.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.function.Function;

public class P14725 {
    static class TrieNode{
        Map<String, TrieNode> children = new TreeMap<>(); // 순서있으므로 TreeMap
        boolean isLast;
    }

    static class Trie{
        private TrieNode root;
        Trie(){ root = new TrieNode(); }

        void insert(String[] word){
            TrieNode node = root;
            for (int i = 0; i < word.length; i++) {
                node = node.children.computeIfAbsent(word[i], c -> new TrieNode());
            }
            node.isLast = true;
        }

        void printChildren(TrieNode node, int depth){
            if(node.isLast) return;
            for(String key : node.children.keySet()){
                for (int i = 0; i < depth; i++) {
                    System.out.print("--");
                }
                TrieNode child = node.children.get(key);
                System.out.println(key);
                printChildren(child, depth + 1);
            }
        }
    }

    static Function<String, Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi.apply(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = stoi.apply(st.nextToken());
            String[] sArr = new String[K];
            for (int k = 0; k < K; k++) {
                sArr[k] = st.nextToken();
            }
            trie.insert(sArr);
        }
        trie.printChildren(trie.root, 0);
    }
}
