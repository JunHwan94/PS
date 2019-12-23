package codeSignal

val checkPalindrome: (String) -> Boolean = { it == it.reversed() }
fun main(){
    println(checkPalindrome("abca"))
}