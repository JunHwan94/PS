package baekjoon.문자열

fun main() {
    val br = System.`in`.bufferedReader()
    val arr = Array(26) { -1 }
    val a: Int = 'a'.code
    val input = br.readLine()
    for (c in 'a'..'z') {
        for (i in input.indices) {
            if (input[i] == c) {
                arr[c.code - a] = i
                break
            }
        }
    }
    arr.forEach { print("$it ") }
}