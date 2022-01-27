fun main(){
    println(122.toChar())
    println('~'.code)
    println(solution("AB", 1))
    println(solution("a B z", 4))
}

private fun solution(s: String, n: Int): String{
    var answer = ""
    s.forEach{
        answer += if(it != ' ') {
            val iv = it.code + n
            when {
                iv in 'Z'.code + 1 until 'a'.code || 'z'.code < iv -> {
                    (iv - 26).toChar()
                }
                iv in 'a'.code..'z'.code && iv - 'a'.code < n -> {
                    (iv - 26).toChar()
                }
                else -> iv.toChar()
            }
        }else it
    }
    return answer
//    return String(s.map{
//        val iv = it.toInt() + n
//        if(it != ' '){
//            when{
//                iv in 'a'.toInt() .. 'z'.toInt() -> {
//                    if(iv - 'a'.toInt() < n) (iv - 26).toChar()
//                    else iv.toChar()
//                }
//                'z'.toInt() < iv -> {
//                    (iv - 26).toChar()
//                }
//                else -> iv.toChar()
//            }
//        }else it
//    }.toCharArray())
}