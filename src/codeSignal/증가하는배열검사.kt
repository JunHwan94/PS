package codeSignal

fun main(){
    println(almostIncreasingSequence(mutableListOf(1,2,3,4,5,-10))) //t
    println(almostIncreasingSequence(mutableListOf(1,3,2,1)))       //f
    println(almostIncreasingSequence(mutableListOf(10,1,2,3,4,5)))  //t
    println(almostIncreasingSequence(mutableListOf(0,-2,5,6)))      //t
    println(almostIncreasingSequence(mutableListOf(1,2,5,3,5)))     //t
    println(almostIncreasingSequence(mutableListOf(1,2,1,2)))     //f
    println(almostIncreasingSequence(mutableListOf(4,5,6,1,2,3)))     //f
//    val list = listOf(1,2,5,3,5)
//    println(list.subList(0, list.indexOf(list.max())) + list.subList(list.indexOf(list.max()) + 1, list.size))
//    println(listOf(1,2,3,4,3,2,1).dropWhile { it <= 2 }) // 조건에 맞으면 계속 drop
//    println(listOf(1,2,3,4).dropLastWhile { it == 2 })

}
fun almostIncreasingSequence(sequence: MutableList<Int>): Boolean {
    // 뒷 원소가 앞 원소보다 작은 경우가 1번 초과
    // 같은 값이 2개 초과
    var i = 0
    do {
        val removeOne = sequence.subList(0, i) + sequence.subList(i + 1, sequence.size)
        if(removeOne == removeOne.sorted()){
            val idx = if(i == sequence.size - 1) i - 1 else i
            if(removeOne.indexOf(removeOne[idx]) != removeOne.lastIndexOf(removeOne[idx])) return false
            return true
        }
        i++
    }while(i < sequence.size)
    return false
//    val zipped = sequence.zipWithNext()
//    if(zipped.filter{ it.first > it.second }.count() > 1 || zipped.filter{ it.first < it.second }.map{ it.first }.zipWithNext().filter{ it.first > it.second }.count() > 0) return false
//    else if(sequence.sorted().zipWithNext().filter{ it.first == it.second }.count() == 1) return true
//    if(sequence.size > 2 && sequence.sorted().zipWithNext().filter{ it.first == it.second }.count() > 0) return false
//    return true
}