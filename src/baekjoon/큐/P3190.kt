package baekjoon.큐

import java.util.*
import kotlin.collections.ArrayList

val posQueue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(1, 1)) }
var N = 0
val apples = ArrayList<Pair<Int, Int>>()
val cmds = LinkedList<Pair<Int, String>>()
fun main(){
    val br = System.`in`.bufferedReader()
    N = br.readLine().toInt()

    repeat(br.readLine().toInt()){
        val input = br.readLine().split(' ')
        apples.add(Pair(input[1].toInt(), input[0].toInt()))
    }

    repeat(br.readLine().toInt()){
        val input = br.readLine().split(' ')
        cmds.offer(Pair(input[0].toInt(), input[1]))
    }

    var sec = 0
    var dir = 0
    var over = false
    // 우하좌상 순
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    while(true){
        dir %= 4
        val nx = posQueue.last().first + dx[dir]
        val ny = posQueue.last().second + dy[dir]
        for(p in posQueue.iterator()){
            if(p.first == nx && p.second == ny){
                sec++
                over = true
                break
            }
        }
        if(over) break
        if(nx > N || ny > N || nx < 1 || ny < 1){
            sec++
            break
        }
        posQueue.offer(Pair(nx, ny))
        var getApple = false
        var appleToRemove: Pair<Int, Int>? = null
        for(i in apples.indices){
            if(apples[i].first == nx && apples[i].second == ny) {
                appleToRemove = apples[i]
                getApple = true
                break
            }
        }
        apples.remove(appleToRemove)
        if(!getApple) posQueue.poll()
        sec++

        if(cmds.isNotEmpty() && cmds.peek().first == sec){
            when(cmds.poll().second){
                "L" -> dir--
                "D" -> dir++
            }
        }
    }
//    println(dir)
    println(sec)
}