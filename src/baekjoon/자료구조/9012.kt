package baekjoon.스택

import java.util.*

fun main() {
    System.`in`.bufferedReader().run {
        val n = Integer.parseInt(readLine())
        val sb = StringBuffer()
        repeat(n) { sb.append(if(isVPS(readLine())) "YES\n" else "NO\n") }
        System.out.bufferedWriter().run {
            write(sb.toString())
            flush()
            close()
        }
        close()
    }
}

fun isVPS(brackets: String): Boolean{
    val stack = Stack<Char>()
    for (i in brackets.indices) {
        when {
            stack.isEmpty() -> stack.push(brackets[i])
            stack.peek() == '(' && brackets[i] == ')' -> stack.pop()
            else -> stack.push(brackets[i])
        }
    }
    return stack.isEmpty()
}