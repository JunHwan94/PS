package baekjoon.완전탐색

import java.io.*

val arr = IntArray(9)
val visited = BooleanArray(9)
val printArr = IntArray(7)
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    for(i in arr.indices){
        arr[i] = Integer.parseInt(br.readLine())
    }
    selectDwarf(0, 0)
}

var isOver = false
fun selectDwarf(sum: Int, depth: Int){
    if(isOver) return
    when{
        sum == 100 && depth == 7 -> {
            printArr.run{
                sort()
                forEach { println(it) }
                isOver = true
            }
            return
        }
        depth > 6 -> return
        sum > 100 -> return
    }

    for(i in arr.indices){
        if(!visited[i]){
            visited[i] = true
            printArr[depth] = arr[i]
            selectDwarf(sum + arr[i], depth + 1)
            visited[i] = false
        }
    }
}