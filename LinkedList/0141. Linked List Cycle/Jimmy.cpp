/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// Floyd's Cycle Finding Algorithm
class Solution {
public:
    // Runtime: 10 ms, faster than 84.30%
    // Memory Usage: 8 MB, less than 58.44%
    // TIME : O(n)
    // SPACE : O(1)
    bool hasCycle(ListNode *head) {
        if (head == nullptr || head->next == nullptr) return false;
        ListNode* fastNode = head;
        ListNode* slowNode = head;
        while (fastNode!=nullptr && fastNode->next!=nullptr) {
            fastNode = fastNode->next->next;
            if (fastNode == nullptr) return false;
            slowNode = slowNode->next;
            if (slowNode == fastNode) return true;
        }
        
        return false;
    }
};