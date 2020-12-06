fun main(){
    println(solution(arrayOf("Jane", "Kim")))
    println(solution1(arrayOf("Jane", "Kim")))
}

private fun solution(seoul: Array<String>): String{
    seoul.forEachIndexed{ i, v -> if(v == "Kim") return "김서방은 ${i}에 있다" }
    return ""
}

private fun solution1(seoul: Array<String>) = "김서방은 ${seoul.indexOf("Kim")}에 있다"