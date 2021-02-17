package baekjoon.큐

import java.util.*

val posQueue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(1, 1)) }
var N = 0
val apples = ArrayList<Pair<Int, Int>>()
val cmds = LinkedList<Pair<Int, Char>>()
fun main(){
    val br = System.`in`.bufferedReader()
    N = br.readLine().toInt()

    repeat(br.readLine().toInt()){
        val input = br.readLine().split(" ")
        apples.add(Pair(input[0].toInt(), input[1].toInt()))
    }
    repeat(br.readLine().toInt()){
        val input = br.readLine().split(" ")
        cmds.add(Pair(input[0].toInt(), input[1][0]))
    }

    var sec = 0
    var dir = 0
    // 우하좌상 순
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    while(apples.size > 0){
        println(apples)
        val nx = posQueue.peek().first + dx[dir]
        val ny = posQueue.peek().second + dy[dir]
        if(nx > N || ny > N || nx < 1 || ny < 1) break
        posQueue.offer(Pair(nx, ny))
        var getApple = false
        for(i in apples.indices){
            if(apples[i].first == nx && apples[i].second == ny) {
                apples.remove(apples[i])
                getApple = true
            }
        }
        if(!getApple) posQueue.poll()
        sec++

        if(cmds.peek().first == sec){
            when(cmds.poll().second){
                'L' -> dir--
                'D' -> dir++
            }
        }
    }
    println(sec)
}