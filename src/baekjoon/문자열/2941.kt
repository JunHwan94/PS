package baekjoon.문자열

fun main(){
    val dic = arrayOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var word = readLine()
    for(alp in dic) {
        word = word!!.replace(alp, "0")
    }
    println(word!!.length)
}