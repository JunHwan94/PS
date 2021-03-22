package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1786 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] t = in.readLine().toCharArray();
		char[] p = in.readLine().toCharArray();
		int tLength = t.length, pLength = p.length;
		
		// 실패함수 만들기
		int[] k = new int[pLength];
	    for(int i = 1, j = 0; i < pLength; i++){// i:접미사 포인터, j:접두사 포인터
	        while(j > 0 && p[i] != p[j]) {
	        	j = k[j - 1]; // 점프
	        }
	        // 같으면 증가
	        if(p[i] == p[j]) k[i] = ++j;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터 
		for(int i = 0,j = 0; i < tLength; ++i) { 
			while(j > 0 && t[i] != p[j])
				j = k[j - 1]; 
			
			if(t[i] == p[j]) { //두 글자 일치
				if(j == pLength - 1) { // j가 패턴의 마지막 인덱스라면 
					cnt++; // 카운트 증가
					list.add((i + 1) - pLength + 1); 
					j = k[j];
				}else { 
					j++;
				}
			}
		}
		
		sb.append(cnt).append('\n');
		if(cnt > 0) {
			for(int i = 0; i < list.size(); i++)
				sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
