/**
 Time : O(m+n)
 Space : O(1)

 Example : 
 
 list1 : 1 -> 5 -> 7
 list2 : 2 -> 3 -> 6
 
  cur | node1 | node2 |
 null |   1   |   2   |    null -> 1
   1  |   5   |   2   |    null -> 1 -> 2
   2  |   5   |   3   |    null -> 1 -> 2 -> 3
   3  |   5   |   6   |    null -> 1 -> 2 -> 3 -> 5
   5  |   7   |   6   |    null -> 1 -> 2 -> 3 -> 5 -> 6
   6  |   7   |  null |    null -> 1 -> 2 -> 3 -> 5 -> 6 -> 7
   7  |  null |  null |
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var node1 = list1
        var node2 = list2
        var head: ListNode? = null
        var cur: ListNode? = null
        
        while(node1 != null || node2 != null) {
            val value1 = node1?.`val` ?: Int.MAX_VALUE
            val value2 = node2?.`val` ?: Int.MAX_VALUE

            if (value1 < value2) {
                cur?.next = node1
                cur = node1
                node1 = node1?.next
            } else {
                cur?.next = node2
                cur = node2
                node2 = node2?.next
            }
            
            if (head == null) {
                head = cur 
            }
        }
        
        return head
    }
}