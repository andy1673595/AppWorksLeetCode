
/**
 Error try times : 1
       5
     4   6
        3  7
 3 should not be less than 5, it's at right of 5

 Time O(n)
 Space O(1)  
*/
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return travel(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
    
    fun travel(node: TreeNode?, min: Long, max: Long): Boolean {
        if (node == null) return true
        
        // Care that we should compare values by Long.
        // -2^31 <= Node.val <= 2^31 - 1
        val value = node.`val`.toLong()
        if (value <= min || value >= max) return false
        
        return travel(node.right, value, max) && travel(node.left, min, value) 
    }
    
}