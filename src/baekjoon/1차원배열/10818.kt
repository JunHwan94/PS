package baekjoon.`1차원배열`

import java.io.*
import java.util.*

//최소, 최대
private fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`)).also{ it.readLine() }
    val token = StringTokenizer(br.readLine())
    var min = 1000000
    var max = -1000000
    while (token.hasMoreTokens()){
        val i = Integer.parseInt(token.nextToken())
        if(i < min) min = i
        if(i > max) max = i
    }
    println("$min $max")
}