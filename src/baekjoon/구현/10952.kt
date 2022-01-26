package baekjoon.`while`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val token = StringTokenizer(br.readLine())
        val a = Integer.parseInt(token.nextToken())
        val b = Integer.parseInt(token.nextToken())
        if(a == 0 && b == 0) break
        println(a + b)
    }
}