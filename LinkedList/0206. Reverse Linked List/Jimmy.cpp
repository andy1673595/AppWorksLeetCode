/**
 * @brief 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
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

class Solution {
public:
    // Runtime: 6 ms, faster than 78.68% 
    // Memory Usage: 8.4 MB, less than 42.65%
    // TIME : O(n)
    // SPACE : O(1)
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {return head;}
        ListNode *currentNode = head->next, *firstNode = head, *nextNode = currentNode->next;
        while (nextNode != nullptr)
        {
            head->next = nextNode;
            currentNode->next = firstNode;
            firstNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode->next;
        }
        
        currentNode -> next = firstNode;
        head -> next = nullptr;
        firstNode = currentNode;

        return firstNode;
    }

    // Runtime: 7 ms, faster than 73.45% 
    // Memory Usage: 8.3 MB, less than 80.37%
    ListNode* reverseListIterationSoln(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while (curr) {
            ListNode* nextTemp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 按我的理解寫的解法
    // Memory Usage: 8.2 MB, less than 97.29%
    ListNode* reverseListIterationSoln2(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {return head;}
        ListNode* rem = head->next;
        ListNode* curr = nullptr;
        ListNode* first = head;
        while (rem) {
            rem = first->next;
            first->next = curr;
            curr = first;
            first = rem;
        }
        return curr;
    }

    // recursion
    // TIME : O(n)
    // SPACE : O(n)
    //
    // // Runtime: 9 ms, faster than 45.53%
    // // Memory Usage: 8.5 MB, less than 10.96%
    // ListNode* reverseListRecursionSoln(ListNode* head) {
    //     if (head == nullptr || head->next == nullptr) {
    //         return head;
    //     }
    //     ListNode* p = reverseList(head->next);
    //     head->next->next = head;
    //     head->next = nullptr;
    //     return p;
    // }

    // Runtime: 31 ms, faster than 6.01% 
    // Memory Usage: 8.6 MB, less than 10.96% 
    ListNode* reverseListRecursionSoln2(ListNode* head) {
        if (head == nullptr || head -> next == nullptr) {return head;}
        ListNode *curr = head;
        ListNode *result = nullptr;
        while(curr->next->next != nullptr) {
            curr = curr->next;
        }

        result = curr->next;
        curr->next = nullptr;
        result->next = reverseListRecursionSoln2(head);
        return result;
    }
};

int main(int argc, char const *argv[])
{
    ListNode *testNode = nullptr, *node;
    for (int i = 5; i > 0; i--) {
        
        if (testNode == nullptr) {
            node = new ListNode(i);
        } else {
            node = new ListNode(i, testNode);
        }

        testNode = node;
    }

    Solution *soln = new Solution();
    soln->reverseListRecursionSoln2(testNode);
    

    return 0;
}
