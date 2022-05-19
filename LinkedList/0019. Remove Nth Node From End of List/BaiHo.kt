/**
Follow up: Could you do this in one pass?
因為 1 <= size <= 30，我們可以直接偷懶用一個 Array 存
然後紀錄每一個點，然後用 size - n 推算回要移除的 indexRemove

需要特別處理當要移除的點為 head 時，必須 return newHead
其餘的情況皆把 indexRemove 左邊的點接上右邊的點即可

Time : O(n)
Space : O(n)
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val array = Array<ListNode?>(30) { null }
        var cur = head
        var index = 0
        while (cur != null) {
            array[index] = cur
            cur = cur.next
            index ++
        }

        val indexRemove = index - n
        if (indexRemove == 0) {
            val newHead = head?.next
            head?.next = null
            return newHead
        } else {
            val recentNode = array[indexRemove - 1]
            val nextNode = recentNode?.next?.next
            recentNode?.next = nextNode
            return head
        }
    }
}