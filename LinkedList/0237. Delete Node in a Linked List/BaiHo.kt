/**
 爛題目...
 唯一需要注意的點為 node 的 `val` 為可變動的 var 
 Input: head = [4,5,1,9,2], node = 1
 
 先把 node 1 的值改成後面的 9
 4 -> 5 -> "9" -> 9 ->2

 然後把原本 node 1 的 next 指到下下個 node(2)
 4 -> 5 -> "9" -> 2

 */
class Solution {
    fun deleteNode(node: ListNode?) {
        if (node == null) return
        node.`val` = node.next!!.`val` 
        node.next = node.next!!.next
    }
}