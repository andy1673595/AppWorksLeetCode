/**
 Travel a tree with depth of node, and compare depth with max

 Only one thing need to be careful, we travel root with depth '1', not with zero.

 Time O(n)
 Space O(1)
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        var max = 0
        fun travel(node: TreeNode?, depth: Int) {
            if (node == null) return
            max = maxOf(max, depth)
            travel(node?.left, depth+1)
            travel(node?.right, depth+1)
        }
        
        travel(root, 1)
        return max
    }
}