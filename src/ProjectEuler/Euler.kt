package ProjectEuler

import java.math.BigInteger
import java.util.*

fun main(){
//    println(problem1())
//    println(problem2())
//    println(problem3())

    println()
//    println(isPrime1(11))
//    println(problem20())
//    println(fac(BigInteger.valueOf(100)))
}

fun problem1(): Int = (1 until 999).asSequence().filter{ it % 3 == 0 || it % 5 == 0 }.fold(0){acc, next -> acc + next}
fun problem2(): Int = generateSequence(1){it + 1}.map{fib(it, 1, 2)}.takeWhile{ it <= 4000000 }.filter{ it % 2 == 0 }.sum()
fun fib(n: Int, acc: Int, next: Int): Int = if(n == 1) acc else fib(n-1, next, acc + next)

fun problem3(): Long {
    var num = 600_851_475_143
    var i: Long = 3
    while(++i != num){
        if(num % i == 0L){
            num /= i
            i = 3
        }
    }
    println(Calendar.getInstance().timeInMillis)
    return num
}


fun problem20(): Int = fac(BigInteger.valueOf(100)).toString().map{ it.toInt() - 48 }.fold(0){ acc, next -> acc + next }
        //fold(BigInteger.ZERO){acc, c: Char -> acc + BigInteger.valueOf(c.toLong()) }
        //.takeWhile { it > BigInteger.ZERO }.fold(BigInteger.ZERO){acc, next -> acc + next} + fac(BigInteger.valueOf(100)) % BigInteger.TEN
fun fac(n: BigInteger): BigInteger = if(n == BigInteger.ONE) BigInteger.ONE else n * fac(n - BigInteger.ONE)
