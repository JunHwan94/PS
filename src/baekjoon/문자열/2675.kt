package baekjoon.문자열

import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    repeat(Integer.parseInt(br.readLine())){
        val token = StringTokenizer(br.readLine())
        val rep = Integer.parseInt(token.nextToken())
        val sb = StringBuffer()
        token.nextToken().forEach{ c ->
            repeat(rep){ sb.append(c) }
        }
        bw.write("${sb}\n")
    }
    bw.flush()
}