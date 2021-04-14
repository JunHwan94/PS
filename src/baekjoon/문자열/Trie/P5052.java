package baekjoon.문자열.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P5052 {
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isTerminal;
        int count = 0;
    }

    static class Trie{
        private final TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        void insert(String key){
            TrieNode trie = this.root;
            for(int i = 0; i < key.length(); i++){
                trie.count++;
                trie = trie.children.computeIfAbsent(key.charAt(i), c -> new TrieNode());
            }
            trie.isTerminal = true;
        }

        // key 문자열이 포함된 문자열이 있는지 검사
        int countChildren(String key){
            TrieNode trie = this.root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                TrieNode childTrie = trie.children.get(c);
                if(childTrie == null) return 0;
                trie = childTrie;
            }
            return trie.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Trie root = new Trie();
            Set<String> ss = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String in = br.readLine();
                root.insert(in);
                ss.add(in);
            }

            String res = "YES";
            for(String key : ss){
                if(root.countChildren(key) > 0) { // 문자열이 포함된 문자열이 있는지 검사
                    res = "NO";
                    break;
                }
            }

            System.out.println(res);
        }
    }
}
