/**
 Process an inorder traversal iteratively

 Failed one time : [1,2,2,2,null,2] -> [2, 2, 1, 2, 2]
 
 We need recode the node is from right or left : Pair<Int, Boolean>
 [(2, true), (2, true), (1, true), (2, true), (2, false)]


 Time o(n)
 Space O(n)
 */

 class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        // Boolean == true means from left
        val traveled = mutableListOf<Pair<Int, Boolean>>()
        val stack = Stack<Pair<TreeNode, Boolean>>()
        var cur: Pair<TreeNode?, Boolean> = Pair(root, true)

        // Travel the tree iteratively
        // 'cur' means node has not been traveled ever
        // Each node in 'stack' means has traveled left child
        while (cur.first != null || stack.isNotEmpty()) {
            if (cur.first != null) {
                stack.add(Pair(cur.first!!, cur.second))
                // travel left child
                cur = Pair(cur.first!!.left, true)
            } else {
                val pair = stack.pop()
                traveled.add(Pair(pair.first.`val`, pair.second))
                // travel right child
                cur = Pair(pair.first.right, false)
            }

        }
       // println(traveled)
        var s = 0
        var e = traveled.size - 1

        while (e > s) {
            // Value of nodes should be equivalent, but direction of nodes should be contrary
            if (traveled[s].first != traveled[e].first) return false
            if (traveled[s].second == traveled[e].second) return false
            e --
            s ++
        }
        return true
    }
}

/**
 Recursively solution :
 We compare the value of node from correspond positions at left and right.
 */
class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        return travel(root?.left, root?.right)
    }
    
    fun travel(left: TreeNode?, right: TreeNode?): Boolean {
        // both of them are null
        return if (left == right) {
            true
        } else {
            (left?.`val` == right?.`val`) && travel(left?.left, right?.right) && travel(left?.right, right?.left)
        }
    }
}


