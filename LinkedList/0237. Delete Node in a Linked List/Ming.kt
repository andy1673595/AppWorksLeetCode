/*
1. node 不是最後一個(tail)，所以不用對 node.next 做 null check
2. delete node -> 直接將 node 設為 null，還是讓他沒有被 reference 而被 garbage collection

Input: head = [4,5,1,9], node = 5 -> [4,1,9]
[1] 改 val:  ListNode(4) -> ListNode(1) -> ListNode(1) -> ListNode(9)
[2] 改 next: ListNode(4) -> ListNode(1) ->                ListNode(9)
 */

class Solution {
    fun deleteNode(node: ListNode?) {
        // if (node!!.next == null) return
        var tmp = node!!.next
        node.`val` = tmp!!.`val`
        node.next = tmp!!.next
        tmp = null // isolate this mode from list
    }
}