package Level1

import java.util.*

fun main(){
    println(solution("Zbcdefg"))
    println(solution1("Zbcdefg"))
}

private fun solution(s: String): String{
    val start = Calendar.getInstance().timeInMillis
    return String(s.toCharArray().sortedArrayDescending()).also{
        println("${Calendar.getInstance().timeInMillis - start}ms")
    }
}

private fun solution1(s: String): String{
    val start = Calendar.getInstance().timeInMillis
    var answer = ""
    val str = s.toCharArray()
    for(i in 0 until str.size){
        for(j in i until str.size){
            if(str[i] < str[j]){
                val temp = str[i]
                str[i] = str[j]
                str[j] = temp
            }
        }
    }
    str.forEach{ answer += it }
    println("${Calendar.getInstance().timeInMillis - start}ms")
    return answer
}