/**
 Create the subtree with the indices from start to end.
 The top ancestor (a.k.a root) will be the mid index in range [start, end] 
 Then, left part subtree will be [start, mid-1] and right is [mid+1, end]
 
 Example:  [-3, -2, 0, 1, 2, 4, 5, 7, 10]

                mid = (0+9)/2 = 4
        [-3, -2, 0, 1, "2", 4, 5, 7, 10]
                /                   \
       mid = (0+3)/2 = 1       mid = (5+9)/2 = 7
        [-3, "-2", 0, 1]         [4, 5, "7", 10]
            /       \              /     \
         [-3]     ["0", 1]      ["4", 5]   [10]
                      \             \
                      [1]           [5] 
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        
        fun createTree(start: Int, end: Int): TreeNode? {
            if (start > end) return null
            val mid = (start+end)/2
            val node = TreeNode(nums[mid])
            node.left = createTree(start, mid-1)
            node.right = createTree(mid+1, end)
            return node
        }
        
        return createTree(0, nums.size-1)
    }
}