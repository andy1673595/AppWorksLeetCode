/**
In this question, E = V
Time : O(E)
Space: O(E)
 */

class Solution {
    fun longestCycle(edges: IntArray): Int {
        val visited = mutableSetOf<Int>()
        val circle = mutableMapOf<Int, Int>()
        var max = -1

        fun travelsal(n: Int, dis: Int) {
            if (circle.containsKey(n)) {
                // When we found a circle.
                // For case 0 -> 1 -> 2 -> 3 -> 4 -> 2
                // disCircle = 5 - 2 = 3
                val disCircle = dis - circle[n]!!
                max = maxOf(disCircle, max)
                circle.clear()
            } else if(n == -1 || visited.contains(n)) {
                // Reach visited or end vertex.
                circle.clear()
            } else {
                // Traversal next vertex.
                visited.add(n)
                circle[n] = dis
                travelsal(edges[n], dis+1)
            }
        }

        for (e in edges) {
            travelsal(e, 0)
        }
        return max
    }
}