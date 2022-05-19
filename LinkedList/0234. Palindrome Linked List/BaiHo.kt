/**
把所有的 node 存到 list 裡面，然後比較頭尾

Time O(n)
Space O(n)


Follow up space(1) & Time(n) ... 有點想不太到
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