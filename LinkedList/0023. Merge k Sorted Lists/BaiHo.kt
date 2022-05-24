/**
 把所有的 ListNode 丟到一個 queue 裡
 如果 queue 的大小大於 1，就把頭兩個做 merge 然後把結果塞回最後面
 最後回傳 queue 裡剩下的那個 ListNode，如果 queue 為空代表一開始 lists 就是空的

 假設所有的 ListNode 長度為 m, lists 長度為 n
 
 Time : 2*m*(n/2) + 4*m*(n/4) ... + 2^k*m*(n/(2^k)) = mn + mn ... + mn = O(mnlogn)
 Space : queue 的長度 -> O(n)
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = LinkedList<ListNode?>()
        queue?.addAll(lists)
        
        while (queue.size >= 2) {
            val listMerged = merge(queue.poll(), queue.poll())
            queue.add(listMerged)
        }
        
        return if (queue.isEmpty()) {
            null
        } else {
            queue.first()
        }
    }
    
    fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
        var node1 = list1
        var node2 = list2
        var head: ListNode? = null
        var cur: ListNode? = null
        
        while (node1 != null || node2 != null) {
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