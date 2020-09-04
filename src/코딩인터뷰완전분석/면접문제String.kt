package 코딩인터뷰완전분석

import java.util.*
import javax.print.DocFlavor

fun main(){
//    println(check1("abcde"))
//    println(check1("abcda"))
//    println(check1("abcdf"))
//    println(check1("ababc"))
//
//    println(check2("abcde"))
//    println(check2("abcda"))
//    println(check2("abcdf"))
//    println(check2("ababc"))

    println(canMakePalindromeCheck("abbac"))
    println(canMakePalindromeCheck("abbacd"))
    println(canMakePalindromeCheck("aabbccddeeffgg"))
    println(canMakePalindromeCheck("aabbccddzeeffgghh"))
}

fun check1(str: String): String{
//    val tim = Calendar.getInstance().timeInMillis
    var i = 0
    do{
        var j = i + 1
        do{
            if(str[i] == str[j]) {
//                println(Calendar.getInstance().timeInMillis - tim)
                return "중복 문자 있음"
            }
            j++
        }while(j < str.length)
        i++
    }while(i < str.length - 1)
//    println(Calendar.getInstance().timeInMillis - tim)
    return "중복 없음"
}

fun check2(str: String): String{
//    val tim = Calendar.getInstance().timeInMillis
    var i = 0
    for(c in str) {
        if(str.filter { it == c }.count() > 1) {
//            println(Calendar.getInstance().timeInMillis - tim)
            return "중복 문자 있음"
        }
    }
//    println(Calendar.getInstance().timeInMillis - tim)
    return "중복 없음"
}

fun replaceBlank(str: String): String {
    return str.replace(" ", "%20")
}

fun canMakePalindromeCheck(str: String): Boolean {
    // 길이가 짝수인 경우 모든 항의 문자열 내 갯수가 짝수여야함
    if(str.length % 2 == 0) {
        if(!str.filter { c1 -> str.filter { c2 -> c1 == c2 }.count() % 2 == 0 }.contentEquals(str)) return false
    }else{  // 홀수인 경우 문자열 내 갯수가 1개인 항이 1개만 존재해야함
        if(str.filter{ c1 -> str.filter{ c2 -> c1 == c2 }.count() == 1 }.count() > 1) return false
    }
    return true
}

fun rotate(matrix: Array<IntArray>){
    val tmpArr = arrayOfNulls<Int>(matrix.size)

}