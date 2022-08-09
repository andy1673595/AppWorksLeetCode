class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

root = TreeNode(
    val=1, 
    left=TreeNode(
        val=2, 
        left=TreeNode(
            val=3, 
            left=None, 
            right=None
        ),
        right=TreeNode(
            val=4,
            left=None, 
            right=None
    )),
    right=TreeNode(
        val=2, 
        left=TreeNode(
            val=4,
            left=None,
            right=None
        ),
        right=TreeNode(
            val=3,
            left=None,
            right=None
        ),
    )
)

class Solution:
    def isSymmetric(self, root):
        if not root:
            return True
        tmp = [(root.left, root.right)]
        while tmp:
            l, r = tmp.pop()
            if not l and not r:
                continue
            if not l or not r:
                return False
            if (l.val != r.val):
                return False
            tmp.append((l.left, r.right))
            tmp.append((l.right, r.left))
        return True
    
    def recursive(self, root):
        return

ans = Solution().isSymmetric(root)
print(ans)