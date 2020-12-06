package Level1

fun main(){
    print(solution("try hello world"))
    print(solution1("try hello world"))
}

private fun solution(s: String): String{
    var answer = ""
    var wi = 0
    s.forEach{
        answer += if(wi % 2 == 0) it.toUpperCase()
        else it.toLowerCase()
        wi++
        if(it == ' ') wi = 0
    }
    return answer
} // 이게 시간복잡도가 덜할 듯

private fun solution1(s: String): String{
    var answer = ""
    s.split(" ").forEach{
        for(i in 0 until it.length){
            answer += if(i % 2 == 0) it[i].toUpperCase()
            else it[i].toLowerCase()
        }
        answer += " "
    }
    return answer
}