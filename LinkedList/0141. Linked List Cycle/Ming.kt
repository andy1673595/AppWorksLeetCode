
/*
time:  O(n)
space: O(1)

-10的5次方 <= Node.val <= 10的5次方
以不在範圍的 Integer MIN VALUE( -2147483648) 作為記號已經走過這個值
當有值等於 Integer MIN VALUE，代表在 cycle 裡
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var node = head
        while (node != null) {
            if (node.`val` == Integer.MIN_VALUE) {
                return true
            } else {
                node.`val` = Integer.MIN_VALUE
                node = node.next
            }
        }
        return false
    }
}
