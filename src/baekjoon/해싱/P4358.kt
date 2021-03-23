package baekjoon.해싱

import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val hSet = HashSet<String>()
    val map = HashMap<String, Int>()
    for(i in 0 until 1000000){
        val input = br.readLine()
        input.length
        hSet.add(input)
    }
    for(s in hSet) {
        if(map.keys.contains(s)) map[s] = map[s]!! + 1
        else map[s] = 1
    }
    val tSet = TreeSet(hSet)
    for(s in tSet){
        println(String.format("%.4f", map[s]!! / hSet.size.toDouble()))
    }
}