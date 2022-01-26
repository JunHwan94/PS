package baekjoon.자료구조

import java.util.*

// 스택
fun main() {
    val br = System.`in`.bufferedReader()
    val size = Integer.parseInt(br.readLine())
    val stack = Stack(size)
    with(StringBuffer()) {
        for (i in 0 until size) {
            val token = StringTokenizer(br.readLine())
            if (token.countTokens() == 2) {
                token.nextToken()
                stack.push(Integer.parseInt(token.nextToken()))
            } else {
                when (token.nextToken()) {
                    "pop" -> append("${stack.pop()}\n")
                    "size" -> append("${stack.size()}\n")
                    "empty" -> append("${stack.empty()}\n")
                    "top" -> append("${stack.top()}\n")
                }
            }
        }
        print(this)
    }
}

class Stack(size: Int){
    var arr = Array(size){ 0 }
    var realSize = 0
    fun push(x: Int) { arr[realSize++] = x }

    fun pop() =
            when(realSize){
                0 -> -1
                else -> {
                    val result = arr[realSize - 1]
                    arr[realSize-- - 1] = 0
                    result
                }
            }

    fun size() = realSize

    fun empty() =
            if(realSize == 0) 1
            else 0

    fun top() =
        when (realSize) {
            0 -> -1
            else -> arr[realSize - 1]
        }
}