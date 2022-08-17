class Solution:
    def closestMeetingNode(self, edges, node1, node2):
        def dfs(start_node, node_steps):
            count = 0
            next_node = edges[start_node]
            node_steps[start_node] = count
            while next_node != -1 and node_steps[next_node] == -1:
                count += 1
                node_steps[next_node] = count
                next_node = edges[next_node]
            return

        node1_steps = [-1 for i in range(len(edges))]
        node2_steps = [-1 for i in range(len(edges))]

        dfs(node1, node1_steps)
        dfs(node2, node2_steps)

        ans = -1
        res = float("inf")
        for j in range(len(edges)):
            if node1_steps[j]!= -1 and node2_steps[j]!= -1:
                maximum_distance = max(node1_steps[j], node2_steps[j])
                if maximum_distance < res :
                    res = maximum_distance
                    ans = j
        return ans
        

edges = [4,4,4,5,1,2,2]
node1 = 1
node2 = 1

Solution().closestMeetingNode(edges, node1, node2)


