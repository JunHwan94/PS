package baekjoon.`for`

import java.io.*
import java.util.*

// A+B - 8
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    var token: StringTokenizer
    BufferedWriter(OutputStreamWriter(System.`out`)).run{
        (1..n).forEach{
            token = StringTokenizer(br.readLine())
            val p = Pair(token.nextToken(), token.nextToken())
            write("Case #$it: ${p.first} + ${p.second} = ${p.first.toInt() + p.second.toInt()}")
            newLine()
        }
        flush()
        close()
    }
    br.close()
}