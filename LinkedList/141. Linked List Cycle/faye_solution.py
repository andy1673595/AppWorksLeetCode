# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head):
        left = right = head
        while right and right.next: # 這邊用 right.next.next 會出錯因為 none 沒有 next
            right = right.next.next
            if left == right:
                return True
            left = left.next
        return False

