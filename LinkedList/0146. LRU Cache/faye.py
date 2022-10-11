class Node:
    def __init__(self, key, value, prev=None, next=None):
        self.key = key
        self.value = value
        self.prev = prev
        self.next = next

# Double linked list -> Time: O(1), Space: O(n)
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = dict()
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def _add(self, node: Node) -> None:
        old_head_next = self.head.next
        self.head.next = node
        node.next = old_head_next
        node.prev = self.head
        old_head_next.prev = node

    def _remove(self, node: Node) -> None:
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node

    def get(self, key: int) -> int:
        if key in self.map:
            node = self.map[key]
            self._remove(node)
            self._add(node)
            return node.value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self._remove(self.map[key])
        new_node = Node(key, value, None, None)
        self._add(new_node)
        self.map[key] = new_node
        if len(self.map.keys()) > self.capacity:
            tail_node = self.tail.prev
            self._remove(tail_node)
            del self.map[tail_node.key]



# ["LRUCache","put","get"]
# [[1],[2,1],[2]]

cache = LRUCache(2)
cache.put(2, 1)
cache.show_path()
cache.get(2)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)