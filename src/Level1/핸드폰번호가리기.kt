fun main(){
    println(solution("01028120671"))
}

private fun solution(pn: String): String{
     var answer = ""
     for(i in pn.indices){
         answer += if(i < pn.length - 4) '*'
                 else pn[i]
     }
     return answer
}