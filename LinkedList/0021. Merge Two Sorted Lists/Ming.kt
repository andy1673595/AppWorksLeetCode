

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {        
        if (list1 == null) return list2
        if (list2 == null) return list1

        if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            return list1
        }

        list2.next = mergeTwoLists(list2.next, list1)
        return list2
    }
}
