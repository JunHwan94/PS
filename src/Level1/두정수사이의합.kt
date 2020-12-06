fun main(){
    println(solution(-9999998, 10000000))
    println(solution1(5, 3))
    println(solution1(3, 3))
}

private fun solution(a: Int, b: Int) = sequence { yieldAll(Math.min(a, b)..Math.max(a, b)) }
        .map{ it.toLong() }
        .sum()
private fun solution1(a: Int, b: Int) = (Math.abs(a - b) + 1) * (a + b) / 2L