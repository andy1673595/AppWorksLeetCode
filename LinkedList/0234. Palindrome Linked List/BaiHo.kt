/**
把所有的 node 存到 list 裡面，然後比較頭尾

Time O(n)
Space O(n)

 */
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        val stack = LinkedList<ListNode>()
        var cur = head
        while (cur != null) {
            stack.add(cur)
            cur = cur.next
        }
        
        while (stack.size >= 2) {
            val front = stack.pollFirst()
            val back = stack.pollLast()
            if (front.`val` != back.`val`) return false
        }
        
        return true
        
    }
}


/**
 Follow up : 要求 Time O(n) & Space O(1)
 想法 : 找出對稱的中心點，反轉前半段，然後逐一比對


 */
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        // calculate total length
        var size = 0
        var cur = head
        while (cur != null) {
            size ++
            cur = cur.next
        }

        // find the last node of first half part
        // If size is odd, ex: 1 - 2 - 3 - 4 - 5, lastOfFirstHalf => 2
        // Else, size is even, ex: 1 - 2 - 3 - 4 - 5 - 6, lastOfFirstHalf => 3
        var mid = size/2
        var lastOfFirstHalf = head
        // Take care that we will take next node util mid > 1, not mid > 0
        while (mid > 1) {
            lastOfFirstHalf = lastOfFirstHalf?.next
            mid --
        }
        
        // If size is odd, we ignore the next node (which is the middle node of whole list)
        var laterHalf = if (size % 2 == 1) {
            lastOfFirstHalf?.next?.next
        } else {
            lastOfFirstHalf?.next
        }
        lastOfFirstHalf?.next = null

        // Reverse first part
        var firstHalf = reverseList(head)

        // Compare each node of first part and later part
        while (firstHalf != null && laterHalf != null) {
            if (firstHalf.`val` != laterHalf.`val`) return false
            firstHalf = firstHalf.next
            laterHalf = laterHalf.next
        }
        return true
    }

    fun reverseList(head: ListNode?): ListNode? {
        val next = head?.next
        if (next != null) {
            head.next = null
            val newHead = reverseList(next)
            next?.next = head
            return newHead
        } else {
            return head
        }
    }
}