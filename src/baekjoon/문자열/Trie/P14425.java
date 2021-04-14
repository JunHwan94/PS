package baekjoon.문자열.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P14425 {
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isTerminal;
    }

    static class Trie{
        private final TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        void insert(String key){
            TrieNode trie = this.root;
            for (int i = 0; i < key.length(); i++) {
                // 자식으로 없는 것들만 새 객체로 넣음 | apple -> app 가 있으면 le를 자식으로 생성
                trie = trie.children.computeIfAbsent(key.charAt(i), c -> new TrieNode());
            }
            trie.isTerminal = true; // 존재하는 단어의 끝 표시
        }

        boolean contains(String key){
            TrieNode trie = this.root;

            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                TrieNode childTrie = trie.children.get(c);
                if(childTrie == null) return false;
                trie = childTrie;
            }

            return trie.isTerminal; // 존재하는 단어의 끝
        }
    }

    // 소문자로만 이루어짐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie root = new Trie();
        for (int i = 0; i < N; i++)
            root.insert(br.readLine());

        String[] inputs = new String[M];
        for (int i = 0; i < M; i++)
            inputs[i] = br.readLine();

        int count = 0;
        for (int i = 0; i < M; i++)
            if(root.contains(inputs[i])) count++;

        System.out.println(count);
    }
}
