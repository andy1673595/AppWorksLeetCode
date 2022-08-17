class Solution {
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val nodes = Array(n) { mutableListOf<Int>() }
        val visited = BooleanArray(n)
        val dfn = IntArray(n)
        val low = IntArray(n)
        // tarjan timestamp
        var order = 0
        // critical bridges
        val bridges = mutableListOf<List<Int>>()

        for (edge in connections) {
            nodes[edge[0]].add(edge[1])
            nodes[edge[1]].add(edge[0])
        }

        fun tarjan(from: Int, root: Int) {
            dfn[root] = order
            low[root] = order
            order++
            visited[root] = true
           
            for (e in nodes[root]) {
                if (e == from) continue
                if (visited[e]) {
                    low[root] = minOf(low[root], dfn[e])
                } else {
                    tarjan(root, e)
                    low[root] = minOf(low[root], low[e])
                    if (dfn[root] < low[e]) {
                        bridges.add(listOf(root, e))
                    }
                }
            }
            
        }

        tarjan(-1, 0)
        return bridges
    }

}