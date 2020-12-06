fun main(){
    println(solution(5))
    println(solution1(5))
    println(solution2(5))
    println(solution3(5))
}

private fun solution(n: Int): Int{
    var answer = n
        for(i in 1 .. n / 2)
            if(n % i == 0) answer += i
    return answer
}

private fun solution1(n: Int) = n + generateSequence(1){ it + 1 }.take(n / 2).filter{ n % it == 0 }.sum()
private fun solution2(n: Int) = n + (1 .. n / 2).filter{ n % it == 0 }.sum()
private fun solution3(n: Int) = n.run{
    var answer = this
    for(i in 1 .. n / 2)
        if(this % i == 0) answer += i
    answer
}