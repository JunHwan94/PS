fun main(){
    println(solution(100))
    println(solution(3))
    println(solution(4))
}

private fun solution(n: Long): Long{
    val root = Math.sqrt(n.toDouble()).toLong()
    return if(n == root.times(root))
        (root.inc()).times(root.inc())
    else -1
}