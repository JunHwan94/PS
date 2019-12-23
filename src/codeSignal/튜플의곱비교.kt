package codeSignal

val adjacentElementsProduct: (MutableList<Int>) -> Int = {
//    it.withIndex().forEach{ i -> if(i.index + 1 < it.size && largest < i.value * it[i.index + 1]) largest = i.value * it[i.index + 1] }
    it.zipWithNext(Int::times).max()!!
}

fun main(){
    println(adjacentElementsProduct(mutableListOf(3,6,-2,-5,7,3)))
    println(adjacentElementsProduct(mutableListOf(5,1,2,3,1,4)))

}