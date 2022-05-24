# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head, n):
            node_array = []
            cur = head
            while cur:
                node_array.append(cur)
                cur = cur.next
            remove_target_index = len(node_array) - n
            remove_target = node_array[remove_target_index]
            if remove_target_index == 0:
                head = head.next
            else:
                prev = node_array[remove_target_index - 1]
                prev.next = node_array[remove_target_index].next
            return head
