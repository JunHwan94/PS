package baekjoon.스택

import java.util.*

// 제로
fun main(){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val stack = Stack<Int>()
    repeat(n){
        val i = Integer.parseInt(br.readLine())
        if(i == 0) stack.pop()
        else stack.push(i)
    }
    println(stack.sum())
}