/**
 Recursive solution
 
 Memory space : O(n)
 Time : O(n)

 Example : 1 -> 2 -> 3
 
 reverseList(1) {
     next = 2
     newHead = reverseList(2)
     2->next = 1
     return newHead
 }

 reverseList(2) {
     next = 3
     newHead = reverseList(3) 
     3->next = 2
     return newHead
 }

 reverseList(3) {
     next = null
     return 3
 }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        val next = head?.next
        if (next != null) { 
            // This step is very important (wrong 1 time)
            head.next = null
            val newHead = reverseList(next)
            next?.next = head
            return newHead
        } else {
            return head
        }
    }
}

/**
 Iterative solution
 Space : O(1)
 Time : O(n)

 Example : 1 -> 2 -> 3 
 
 Turn 1 :          1  ->   2  -> 3
         recent   cur    next

 Turn 2 :          1  ->    2  ->  3
                  recent    cur    next

 Turn 3 :          1  ->    2  ->  3
                          recent   cur    next
 
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var recent: ListNode? = null
        var cur = head
        
        while(cur != null) {
            val next = cur.next
            cur.next = recent
            // Set up variables for next turn
            recent = cur
            cur = next
        }
        
        return recent
    }
}
