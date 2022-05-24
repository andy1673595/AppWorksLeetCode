/*
 time:  O(N)
 space: O(2) ? 
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var reversed: ListNode? = null
        var current: ListNode? = head

        while (current != null) {
            reversed = ListNode(current.`val`).apply { next = reversed }
            current = current.next
        }

        return reversed
    }
}