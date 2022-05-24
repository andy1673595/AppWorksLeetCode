/*
 time:  O(2N) ?
 space: O(2) ?
 */

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var reverse: ListNode? = null
        var newHead: ListNode? = head

        while (newHead != null) {
            reverse = ListNode(newHead.`val`).apply { next = reverse }
            newHead = newHead.next
        }

        newHead = head
        while (newHead != null) {
            if(newHead.`val`!=reverse!!.`val`) return false

            newHead = newHead.next
            reverse = reverse.next
        }

        return true
    }
}