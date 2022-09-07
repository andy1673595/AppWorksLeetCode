/**
 Time : O(E+V)
 Space: O(E+V)

 */
// (to vertex, cost)
typealias Edge = Pair<Int, Int>

data class Next(
    val nextVertex: Int,
    val cost: Int,
    val stop: Int
)

class Solution {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // DP for cost fo each vertex
        val costs = IntArray(n) { Int.MAX_VALUE }
        val graph = Array(n) { mutableListOf<Edge>() }
        val queue = LinkedList<Next>()

        flights.forEach { f ->
            graph[f[0]].add(f[1] to f[2])
        }

        queue.add(Next(src, 0, 0))

        // BFS
        while (queue.isNotEmpty()) {
            val next = queue.poll()!!
            if (next.nextVertex == dst) {
                costs[dst] = minOf(costs[dst], next.cost)
            }
            if (next.stop > k) {
                continue
            }
            if (costs[next.nextVertex] <= next.cost) {
                continue
            }
            costs[next.nextVertex] = next.cost
            graph[next.nextVertex].forEach { e ->
                queue.add(Next(
                    nextVertex = e.first,
                    cost = e.second + next.cost,
                    stop = next.stop + 1
                ))
            }
        }

        return if (costs[dst] == Int.MAX_VALUE) -1 else costs[dst]
    }
}
    