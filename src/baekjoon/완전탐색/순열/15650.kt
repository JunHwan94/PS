package baekjoon.완전탐색.순열

import java.lang.StringBuilder
import java.util.*

// n과 m (2)
const val MAX = 9
var n = 0
var m = 0
val arr = Array(MAX){ 0 }
val bArr = BooleanArray(MAX)
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
        if(!bArr[i]) {
            bArr[i] = true
            arr[cnt] = i
            permutation(cnt + 1)
            bArr[i] = false
        }
    }
}