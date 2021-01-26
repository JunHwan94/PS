package baekjoon.완전탐색.P2798

import java.util.*

var arr = IntArray(0) // 입력받을 배열
val dList = ArrayList<Int>() // 차이 리스트
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

        var min = 300_000
        var index = 0
        for(i in dList.indices) {
            if(dList[i] < min) {
                min = dList[i]
                index = i
            }
        }

        println(m - dList[index])
    }
}

fun dfs(sum: Int, depth: Int){
    when{
        depth == 3 -> {
            if(sum <= m) {
                dList.add(m - sum) // 각 합의 차이 저장
            }
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