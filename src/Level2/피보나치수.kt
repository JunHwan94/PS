package Level2

fun main(){
    tailrec fun f(n: Int, a: Int, b: Int): Int = if(n == 1) a else f(n - 1, b % 1234567, (a + b) % 1234567)
    val solution: (Int) -> Int = { n -> if(n == 1 || n == 2) 1 else f(n, 1, 1) }
}