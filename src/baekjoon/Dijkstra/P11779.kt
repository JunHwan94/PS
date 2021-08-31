package baekjoon.FloydWarshall

import java.util.*
import kotlin.collections.ArrayList

var n = 0
var m = 0
lateinit var dist: IntArray
lateinit var edgeList: Array<ArrayList<Edge>>
class Edge(var to: Int, var dist: Int) : Comparable<Edge>{
    override fun compareTo(other: Edge) = dist - other.dist
}
fun main(){
    n = readLine()!!.toInt()
    m = readLine()!!.toInt()
    edgeList = Array(n + 1){ ArrayList(n + 1) }
    repeat(m){
        val line = readLine()!!.split(" ")
        edgeList[line[0].toInt()].add(Edge(line[1].toInt(), line[2].toInt()))
    }

    val line = readLine()!!.split(" ")
    val from = line[0].toInt()
    val to = line[1].toInt()

    val q = PriorityQueue<Edge>()
    q.offer(Edge(from, 0))
    dist = IntArray(n + 1){ 100_000_000 }
    dist[from] = 0
    val visited = BooleanArray(n + 1)
    val route = IntArray(n + 1)
    while(q.isNotEmpty()){
        val curEdge = q.poll()
        val current = curEdge.to
        if(visited[current]) continue
        visited[current] = true
        for (edge in edgeList[current]){
            if(dist[edge.to] > dist[current] + edge.dist){
                dist[edge.to] = dist[current] + edge.dist
                q.offer(Edge(edge.to, dist[edge.to]))
                route[edge.to] = current
            }
        }
    }

    var i = to
    val stack = Stack<Int>()
    while(true){
        stack.push(i)
        if(i == from) break
        i = route[i]
    }

    println("${dist[to]}")
    println(stack.size)
    while(stack.isNotEmpty()) print("${stack.pop()} ")
}