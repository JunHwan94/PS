package baekjoon.`for`

import java.io.*
import java.util.*

// A+B - 7
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    var token: StringTokenizer
    val stoi: (String) -> Int = { Integer.parseInt(it) }
    BufferedWriter(OutputStreamWriter(System.`out`)).run{
        (1..n).forEach{
            token = StringTokenizer(br.readLine())
            val p = Pair(token.nextToken(), token.nextToken())
            write("Case #$it: ${stoi(p.first) + stoi(p.second)}")
            newLine()
        }
        flush()
        close()
    }
    br.close()
}