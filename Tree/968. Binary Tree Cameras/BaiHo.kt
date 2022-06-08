
class Solution {
    var ans = 0
    fun minCameraCover(root: TreeNode?): Int {
        if (root == null) return 0
        if (need(root).first) { ans++ }
        return ans
    }
    // return Pair(needLight, lightByItSelef)
    fun need(node: TreeNode?): Pair<Boolean, Boolean> {
       if (node == null) return Pair(false, false)

       // Pair(needLight, lightByItSelef)
       val left = need(node.left)
       // Pair(needLight, lightByItSelef)
       val right = need(node.right)
       
       if (left.first || right.first) {
           ans ++
           return Pair(false, true)
       }
       
       if (!left.second && !right.second) return Pair(true, false)
       return Pair(false, false)
    }
}