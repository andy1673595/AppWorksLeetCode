fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    return when {
        l1 == null && l2 == null -> null
        l1 == null -> l2
        l2 == null -> l1
        l1.`val` < l2.`val` -> {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        }
        else -> {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}
