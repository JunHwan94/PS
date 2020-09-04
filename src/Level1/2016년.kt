package Level1

import java.util.*

fun main(){
    println(solution(5, 24))
}

fun solution(a: Int, b: Int): String{
    val cal = GregorianCalendar(2016, a - 1, b)
    return when(cal.get(Calendar.DAY_OF_WEEK)){
        1 -> "SUN" 2 -> "MON" 3 -> "TUE" 4 -> "WED" 5 -> "THU" 6 -> "FRI" 7 -> "SAT"
        else -> "NONE"
    }
}