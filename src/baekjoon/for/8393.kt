package baekjoon.`for`

import java.io.BufferedReader
import java.io.InputStreamReader

// 합
private fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val sum = n / 2 * (n + 1)
    print(
            when{
                n % 2 == 0 -> sum
                else -> sum + (n + 1) / 2
            }
    )
}