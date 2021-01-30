package baekjoon.완전탐색.P2798

import java.util.*

// 블랙잭
var arr = IntArray(0) // 입력받을 배열
val pq = PriorityQueue<Int>(Collections.reverseOrder()) // 차이 리스트
val visited = BooleanArray(100)
var m = 0
fun main(){
    // 입력받고 토큰 생성
    StringTokenizer(readLine()).run{
        val n = Integer.parseInt(nextToken())
        m = Integer.parseInt(nextToken())
        arr = IntArray(n)
        // 입력받고 토큰 생성
        StringTokenizer(readLine()).run{
            for(i in 0 until n)
                arr[i] = Integer.parseInt(nextToken())
        }
        dfs(0, 0)
        println(pq.poll())
    }
}

/**
 * @param sum 현재 뽑은 값들의 합
 * @param depth 현재 탐색 깊이
 */
fun dfs(sum: Int, depth: Int){
    when (depth) {
        3 -> {
            if(sum <= m) pq.offer(sum) // 각 합 저장
            return
        }
    }

    for(i in arr.indices){
        if(!visited[i]) {
            visited[i] = true
            dfs(sum + arr[i], depth + 1)
            visited[i] = false
        }
    }
}