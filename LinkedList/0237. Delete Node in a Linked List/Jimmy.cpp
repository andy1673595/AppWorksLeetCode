
/*
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

*/

#include <iostream>
#include <map>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // Runtime: 1192 ms, faster than 64.34%
    // Memory Usage: 294.7 MB, less than 68.47% 
    ListNode* deleteMiddle(ListNode* head) {
        ListNode *fastNode = head;
        ListNode *slowNode = head;

        // if (head->next == nullptr) {return head->next;}
        // Runtime: 1205 ms, faster than 62.92%
        // Memory Usage: 294.8 MB, less than 25.32%
        if (head->next == nullptr) {return nullptr;}

        for(;;) {
            fastNode = fastNode->next->next;
            if (fastNode == nullptr || fastNode->next == nullptr) {
                break;
            }
            slowNode = slowNode->next;
        }

        slowNode->next = slowNode->next->next;

        return head;
    }
};
