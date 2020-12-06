package Level1

import java.util.*

fun main(){
    val start = Calendar.getInstance().timeInMillis
    println(solution3(8))
    println("${Calendar.getInstance().timeInMillis - start}ms")
}

fun solution(n: Int): String = String(CharArray(n){ if(it % 2 == 0) '수' else '박'})
fun solution1(n: Int) = "수박".repeat(n / 2).plus(if(n % 2 != 0) "수" else "")
fun solution2(n: Int) = "수박".repeat(n / 2).plus("수".substring(0, n % 2))
fun solution3(n: Int): String = String(CharArray(n){ "수박"[it % 2] })