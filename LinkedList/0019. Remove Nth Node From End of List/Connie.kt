fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {        
    var pre = ListNode(-1)
    pre.next = head

    var slow: ListNode? = pre
    var fast: ListNode? = pre

    var times = n
    while (times > 0) {
        fast = fast?.next
        times --
    }

    while (fast?.next != null) {
        fast = fast?.next
        slow = slow?.next
    }

    slow?.next = slow?.next?.next

    return pre.next
}
