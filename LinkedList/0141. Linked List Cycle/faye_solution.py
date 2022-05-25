# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 折返點前一個 node 往後算兩格會是 cycle 的起點
# right 先跑兩格，確認跟 left 不一樣後，left 再往後走一格
# 如果這個 list 有 cycle 的話 right 會跟 left 一樣

class Solution:
    def hasCycle(self, head):
        left = right = head
        while right and right.next: # 這邊用 right.next.next 會出錯，因為 none 沒有 next
            right = right.next.next
            if left == right:
                return True
            left = left.next
        return False

