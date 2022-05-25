/*
19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.


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
    // Runtime: 10 ms, faster than 23.22% 
    // Memory Usage: 11 MB, less than 34.02%
    // Follow up: Could you do this in one pass?
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        std::map<int, ListNode*> map;
        int counter = -1;
        ListNode *currentNode = head;
        ListNode *targetNode = nullptr, *finalNode = nullptr;

        while(currentNode != nullptr) {
            counter++;
            map[counter] = currentNode;
            currentNode = currentNode->next;
        }
        counter++;

        targetNode = map[counter - n];
        if (n == counter) {
            finalNode = targetNode->next;
        } else {
            finalNode = map[counter - n - 1];
            finalNode->next = targetNode->next;
            finalNode = map[0];
        }

        return finalNode;
    }

    // Runtime: 14 ms, faster than 5.98% 
    // Memory Usage: 10.8 MB, less than 34.08%
    // 
    // 去掉 slowNode != nullptr 的檢查
    // Runtime: 12 ms, faster than 11.21%
    // Memory Usage: 10.8 MB, less than 34.08% 
    ListNode* removeNthFromEndFastSlow(ListNode* head, int n) {
        // ListNode *fastNode = nullptr, *slowNode = nullptr;
        ListNode *startNode = new ListNode(-1, head);
        ListNode *fastNode = startNode, *slowNode = startNode;
        int counter = 0;

        while(fastNode != nullptr) {
            counter ++;
            fastNode = fastNode->next;
            if (counter > n+1) {
                slowNode = slowNode->next;
            }
        }

        // if (slowNode != nullptr) {
        //      slowNode->next = slowNode->next->next;
        // } else {
        //     return slowNode;
        // }

        slowNode->next = slowNode->next->next;
       
        return startNode->next;
    }

    // Runtime: 4 ms, faster than 73.03%
    // Memory Usage: 10.8 MB, less than 34.08%
    ListNode* removeNthFromEndFastSlow2(ListNode* head, int n) {
        ListNode* start = new ListNode();
        start -> next = head;
        ListNode* slow = start, *fast = start;
        
        for(int i = 1; i <= n; i++)
            fast = fast -> next;
        
        while(fast -> next){
            slow = slow -> next;
            fast = fast -> next;
        }
        
        slow -> next = slow -> next -> next;
        
        return start -> next;
    }
};

int main(int argc, char const *argv[])
{
    int n = 2;
    ListNode *previousNode = nullptr, *node;
    for (int i = 2; i > 0; i--) {
        
        if (previousNode == nullptr) {
            node = new ListNode(i);
        } else {
            node = new ListNode(i, previousNode);
        }

        previousNode = node;
    }

    ListNode *singleNode = new ListNode(1);

    Solution *sol = new Solution();
    ListNode *result = sol->removeNthFromEndFastSlow2(sing, 1);


    std::cout << result->val;

    return 0;
}
