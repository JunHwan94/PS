package baekjoon.`while`

import java.util.*

fun main(){
    Scanner(System.`in`).run{
        while(hasNext())
            println(nextInt() + nextInt())
        close()
    }
}