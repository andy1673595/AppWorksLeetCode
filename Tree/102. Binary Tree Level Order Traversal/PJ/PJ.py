from typing import Optional, List
from collections import deque, defaultdict


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class LevelOrderSolution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        queue = deque([root])
        while len(queue) > 0:
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
            print(node.val)


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        layers = defaultdict(list)
        queue = deque([[0, root]])
        while len(queue) > 0:
            layer, node = queue.popleft()
            layers[layer].append(node.val)
            if node.left:
                queue.append([layer+1, node.left])
            if node.right:
                queue.append([layer+1, node.right])
        output = []
        for i in range(layer+1):
            output.append(layers[i])
        return output