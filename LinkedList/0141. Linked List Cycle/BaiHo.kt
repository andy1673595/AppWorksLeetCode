/**
如果有 cycle 的話一定會有一個無窮回圈
fast 每一 loop 會比 slow 快 1 步，早晚會追上 slow

Time O(n)
Space O(1)
 */
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head?.next
        var fast = head?.next?.next
        
        // 只檢查 fast 因為 fast 比較快，一定會比 slow 先或同時碰到 null
        while (slow != fast && fast != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        
        if (fast == null) return false
        else return true
    }
}