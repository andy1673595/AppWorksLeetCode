/**
 Travel a tree and record depth of each node.
 
 Time O(n)
 Space : levels = O(n)
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val levels = mutableListOf<MutableList<Int>>()
        
        fun travel(node: TreeNode?, depth: Int) {
            if (node == null) return
            if (depth >= levels.size) {
                levels.add(mutableListOf(node.`val`))
            } else {
                levels[depth].add(node.`val`)
            }
            travel(node?.left, depth+1)
            travel(node?.right, depth+1)
        }
        
        travel(root, 0)
        
        return levels
    }
}