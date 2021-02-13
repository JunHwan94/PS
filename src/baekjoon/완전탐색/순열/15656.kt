package baekjoon.완전탐색.순열.P15656

import java.lang.StringBuilder
import java.util.*

// n과 m (7)
const val MAX = 8
var n = 0
var m = 0
var arr = Array(MAX){ 0 }
val sb = StringBuilder()
var list = ArrayList<Int>()
fun main(){
    StringTokenizer(readLine()).run {
        n = Integer.parseInt(nextToken())
        m = Integer.parseInt(nextToken())
        StringTokenizer(readLine()).run{
            while(hasMoreTokens())
                list.add(Integer.parseInt(this.nextToken()))
            list.sort()
        }
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

    for (i in list.indices){
        arr[cnt] = list[i]
        permutation(cnt + 1)
    }
}