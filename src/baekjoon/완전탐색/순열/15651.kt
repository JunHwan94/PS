package baekjoon.완전탐색.순열.P15651

import java.lang.StringBuilder
import java.util.*
// n과 m (3)
const val MAX = 8
var n = 0
var m = 0
var arr = Array(MAX){ 0 }
val sb = StringBuilder()
fun main(){
    StringTokenizer(readLine()).run {
        n = Integer.parseInt(nextToken())
        m = Integer.parseInt(nextToken())
        permutation(0)
    }
    println(sb)
}

fun permutation(cnt: Int){
    if (cnt == m) {
        for (i in 0 until m) {
            sb.append("${arr[i]} ")
        }
        sb.append("\n")
        return
    }

    for (i in 1..n){
        arr[cnt] = i
        permutation(cnt + 1)
    }
}