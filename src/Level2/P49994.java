package Level2;

import java.util.*;
import java.util.function.Function;

public class P49994 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Function<Integer, String> itos = String::valueOf;
    public static int solution(String dirs){
        Map<Character, Integer> idxMap = new HashMap<>();
        idxMap.put('R', 0);
        idxMap.put('D', 1);
        idxMap.put('L', 2);
        idxMap.put('U', 3);
        Set<String> edges = new HashSet<>();

        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int dirIdx = idxMap.get(dir);
            int xx = x + dx[dirIdx];
            int yy = y + dy[dirIdx];
            if(xx < 0 || xx > 10 || yy < 0 || yy > 10) continue;
            String pLoc = itos.apply(x) + itos.apply(y);
            String nLoc = itos.apply(xx) + itos.apply(yy);
            edges.add(pLoc + nLoc);
            edges.add(nLoc + pLoc);
            x = xx;
            y = yy;
        }

        return edges.size() / 2;
    }
}