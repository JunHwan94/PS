package baekjoon.스택

import java.util.*

// 스택 수열
fun main(){
    System.`in`.bufferedReader().run{
        val n = Integer.parseInt(readLine())
        val stack = Stack<Int>()
        val opSb = StringBuffer()
        var putNum = 1
        repeat(n) {
            val input = Integer.parseInt(readLine())
            while(putNum <= input){
                stack.push(putNum)
                opSb.append("+\n")
                putNum++
            }
            if(stack.isNotEmpty() && stack.peek() == input) {
                opSb.append("-\n")
                stack.pop()
            }
        }
        if(stack.isEmpty()) print(opSb.toString())
        else println("NO")
    }
}

// 1 2 3 4 ++++ /
// 1 2 3 ++++- / 4
// 1 2 ++++-- / 4 3
// 1 2 5 6 ++++--++ / 4 3
// 1 2 5 ++++--++- / 4 3 6
// 1 2 5 7 8 ++++--++-++ / 4 3 6
// ++++--++-++----- / 4 3 6 8 7 5 2 1
// 4 3 6 8 7 5 2 1