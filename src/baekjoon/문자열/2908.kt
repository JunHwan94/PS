package baekjoon.문자열

import java.util.*

fun main(){
    System.`in`.bufferedReader().run{
        StringTokenizer(readLine()).also{
            val str1 = it.nextToken()
            val str2 = it.nextToken()
            val first = Integer.parseInt(str1.reversed())
            val second = Integer.parseInt(str2.reversed())
            println(if(first < second) second else first)
        }
    }
}

// 메모리 적고 더 빠름
//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.StringTokenizer
//
//fun reverse (param: Int): Int {
//    var hundreads = param / 100
//    var ten = param % 100 / 10
//    var one = param % 100 % 10
//
//    return one * 100 + ten * 10 + hundreads
//}
//
//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    var st = StringTokenizer(br.readLine())
//
//    var a = Integer.parseInt(st.nextToken())
//    var b = Integer.parseInt(st.nextToken())
//
//    var ans = if(reverse(a) > reverse(b)) reverse(a) else reverse(b)
//
//    print(ans)
//
//}