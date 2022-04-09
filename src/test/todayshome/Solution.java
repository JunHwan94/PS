package test.todayshome;

import java.util.*;

public class Solution {
    public String[] solution1(String path){
        int answerLength = 0;
        int[] dists = new int[100];
        List<String> dirs = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            if(i > 0){
                char prev = path.charAt(i - 1);
                char cur = path.charAt(i);
                if(prev != cur){
                    dists[answerLength]++;
                    answerLength++;
                    if(prev == 'E'){
                        if(cur == 'N'){
                            dirs.add("left");
                        }else{
                            dirs.add("right");
                        }
                    }else if(prev == 'S'){
                        if(cur == 'E'){
                            dirs.add("left");
                        }else{
                            dirs.add("right");
                        }
                    }else if(prev == 'W'){
                        if(cur == 'S'){
                            dirs.add("left");
                        }else{
                            dirs.add("right");
                        }
                    }else if(prev == 'N'){
                        if(cur == 'W'){
                            dirs.add("left");
                        }else{
                            dirs.add("right");
                        }
                    }
                }
            }
        }

        String[] answer = new String[answerLength];
        int i = 0;
        int time = 0;
        while(answerLength > 0){
            if(dists[i] <= 5){
                String dir = "";
                answer[i] = "Time " + time + ": go straight " + dists[i] + "00m and turn " + dirs.get(i);
                answerLength--;
                time += dists[i];
                i++;
            }else{
                time++;
                dists[i]--;
            }
        }
        return answer;
    }

    public String solution2(String call){
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < call.length(); i++) {
            for (int j = 1; j < call.length(); j++) {
                String s = call.substring(i, i + j);
                map.computeIfAbsent(s, k -> 0);
                map.put(s, map.get(s) + 1);
                max = Math.max(max, map.get(s));

                s = s.toLowerCase();
                map.computeIfAbsent(s, k -> 0);
                map.put(s, map.get(s) + 1);
                max = Math.max(max, map.get(s));

                s = s.toUpperCase();
                map.computeIfAbsent(s, k -> 0);
                map.put(s, map.get(s) + 1);
                max = Math.max(max, map.get(s));
            }
        }

        List<String> removeList = new ArrayList<>();
        for (String key : map.keySet()) {
            if(map.get(key) == max){
                removeList.add(key.toLowerCase());
                removeList.add(key);
                removeList.add(key.toUpperCase());
            }
        }

        String answer = call;
        for(String s : removeList){
            answer = answer.replace(s, "");
        }
        return answer;
    }

    public String solution3(String tstring, String[][] variables){
        Map<String, String> dic = new HashMap<>();
        for (int i = 0; i < variables.length; i++) {
            dic.put('{' + variables[i][0] + '}', variables[i][1]);
        }

        StringTokenizer st = new StringTokenizer(tstring);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            String value = findValue(dic, st.nextToken());
            sb.append(value);
            if(st.hasMoreTokens()){
                sb.append(" ");
            }
        }

        String answer = sb.toString();
        return answer;
    }

    private String findValue(Map<String, String> dic, String key) {
        int time = 0;
        while(dic.get(key) != null){
            key = dic.get(key);
            if(time++ > 100000){
                break;
            }
        }
        return key;
    }
}
