package baekjoon.`1차원배열`

import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    repeat(n){
        val token = StringTokenizer(br.readLine())
        val sn = Integer.parseInt(token.nextToken())
        val arr = Array(sn){ token.nextToken().toDouble() }
        val avg = arr.fold(.0){ acc, next -> acc + next } / sn
        val cnt = arr.filter{ it > avg }.count().toDouble()
        println("${String.format("%.3f", cnt / sn * 100)}%")
    }
}