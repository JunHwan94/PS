package ProjectEuler

fun main(){
//    println(problem1())
//    println(problem2())
    println()
}

fun problem1(): Int = (1..999).asSequence().filter{ it % 3 == 0 || it % 5 == 0 }.fold(0){acc, next -> acc + next}
fun problem2(): Int = generateSequence(1){it + 1}.map{fib(it, 1, 2)}.takeWhile{ it <= 4000000 }.filter{ it % 2 == 0 }.sum()
fun fib(n: Int, acc: Int, next: Int): Int = if(n == 1) acc else fib(n-1, next, acc + next)
fun problem20(): 