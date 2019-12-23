package codeSignal

fun makeArrayConsecutive(list: MutableList<Int>): Int{ return list.max()!! - list.min()!! - list.size + 1 }
fun main(){
    println(makeArrayConsecutive(mutableListOf(5,3,2,11)))
}