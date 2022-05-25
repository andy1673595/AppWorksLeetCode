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
        self.next_tail = Node(-1, -1)
        self.prev_head = Node(-1, -1)
        self.prev_head.next, self.next_tail.prev = self.next_tail, self.prev_head

    def _remove(self, node: Node) -> None:
        p = node.prev
        n = node.next
        p.next = n
        n.prev = p

    def _add(self, node: Node) -> None:
        tmp_head_next = self.prev_head.next
        node.prev, self.prev_head.next = self.prev_head, node
        node.next, tmp_head_next.prev = tmp_head_next, node

    def get(self, key: int) -> int:
        if self.map.get(key):
            node = self.map.get(key)
            self._remove(node)
            self._add(node)
            return node.value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map.keys():
            self._remove(self.map[key])
        node = Node(key, value, None, None)
        self._add(node)
        self.map[key] = node

        if len(self.map.keys()) > self.capacity:
            tail_node = self.next_tail.prev
            self._remove(tail_node)
            del self.map[tail_node.key]
