package baekjoon.문자열.Trie;

import java.io.*;
import java.util.function.Function;
import java.util.*;

public class P5670 {
    static class TrieNode{
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean isLastChar;
    }

    static class Trie{
        private TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        void insert(String word){
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node = node.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            node.isLastChar = true;
        }

        boolean contains(String word){
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = curNode.children.get(c);

                if(node == null) return false;
                curNode = node;
            }
            return curNode.isLastChar;
        }

        int typeCount(String word){
            int cnt = 1;
            TrieNode curNode = root;
            curNode = curNode.children.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                // node가 가진 하위 알파벳 갯수가 2개 이상이면 증가
                if(curNode.children.size() > 1) {
                    cnt++;
                }
                // word의 마지막위치가 아닌데 마지막 표시가 되어있으면 증가
                else if(curNode.children.size() == 1 && curNode.isLastChar) {
                    cnt++;
                }
                char c = word.charAt(i);
                TrieNode node = curNode.children.get(c);
                curNode = node;
            }
            return cnt;
        }
    }

    static Function<String, Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while((in = br.readLine()) != null){
            int n = stoi.apply(in);
            String[] sArr = new String[n];
            Trie trie = new Trie();
            for (int i = 0; i < n; i++) {
                sArr[i] = br.readLine();
                trie.insert(sArr[i]);
            }

            int sum = 0;
            for (String s : sArr) {
                sum += trie.typeCount(s);
            }
            System.out.printf("%.2f%n", (double)sum / n);
        }
    }
}
