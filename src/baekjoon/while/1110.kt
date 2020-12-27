package baekjoon.`while`

import java.io.*

// 더하기 사이클
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = Integer.parseInt((br.readLine()))
    if(n < 10) n *= 10
    var cnt = 0
    var i = -1
    var tmp: Int
    while(n != i){
        if(i == -1) i = n
        tmp = i / 10 + i % 10
        i = (i % 10 * 10) + tmp % 10
        cnt++
    }
    println(cnt)
}