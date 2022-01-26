package baekjoon.스택

import java.util.Stack

fun main(){
    val bCnt = readLine()!!.toInt()
    val cnts = Array(bCnt){ 0 }
    val buildings = Array(bCnt){ readLine()!!.toLong() }

    val stack = Stack<Pair<Int, Long>>()
    stack.push(Pair(bCnt - 1, buildings[bCnt - 1]))
    for (i in bCnt - 2 downTo 0){
        while(stack.isNotEmpty()){
            if(buildings[i] <= stack.peek().second){
                cnts[i] = stack.peek().first - i - 1
                break
            }
            stack.pop()
        }
        stack.push(Pair(i, buildings[i]))
    }

    cnts.forEach { print("$it ") }

//    println(cnts.sum())
}