fun deleteNode(node: ListNode?) {
    node?.`val` = node?.next?.`val`
    node?.next = node?.next?.next
}
