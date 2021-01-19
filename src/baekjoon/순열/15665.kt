package baekjoon.순열.P15665

import java.lang.StringBuilder
import java.util.*

// n과 m (11)
const val MAX = 9
var n = 0
var m = 0
var arr = Array(MAX){ 0 }
val sb = StringBuilder()
var list = ArrayList<Int>()
val bMap = HashMap<String, Boolean>()
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
        val tsb = StringBuilder()
        for (i in 0 until m) {
            tsb.append("${arr[i]} ")
        }

        if(!(bMap[tsb.toString()] ?: false)) {
            bMap[tsb.toString()] = true
            sb.append("$tsb\n")
        }
        return
    }

    for (i in list.indices){
        arr[cnt] = list[i]
        permutation(cnt + 1)
    }
}