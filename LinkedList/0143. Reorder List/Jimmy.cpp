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


#include <iostream>
#include <map>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

*/
using namespace std;
#include <vector>

class Solution {
public:
    // 想法：分成兩個 ListNode，一個 0...mid 另一個 mid+1 ... end
    // 然後將 mid+1 ... end 顛倒過來
    // 最後再 merge
    // Runtime: 50 ms, faster than 62.27%
    // Memory Usage: 17.7 MB, less than 77.97%
    // TIME : O(n) + O(n/2) + O(n) -> O(n)
    // SPACE : O(n)
    void reorderList(ListNode* head) {

        if (head == nullptr) {return;}
        
        ListNode *nodeBeforeMid = getNodeBeforeMid(head);
        ListNode *midNode = nodeBeforeMid->next;
        nodeBeforeMid->next = nullptr;

        // created 2 segments : head, list2;
        midNode = reverse(midNode);

        // merge
        head = merge(head, midNode);

        printf("");
    }

private:
    ListNode* getNodeBeforeMid(ListNode* head) {
        ListNode *fastNode = head, *slowNode = head;

        while(fastNode->next != nullptr && fastNode->next->next != nullptr) {
            fastNode = fastNode->next->next;
            slowNode = slowNode->next;
        }

        return slowNode;
    }

    ListNode* reverse(ListNode *head) {
        ListNode *prev = nullptr;
        ListNode *curr = head;

        while (curr)
        {
            ListNode *nextNode = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    ListNode* merge(ListNode* head, ListNode* list2) {
        ListNode *curr = head;
        while (list2 != nullptr) 
        {
            ListNode *nextNode = curr->next; // curr: L1L2L3 ... list2: Ln-mid Ln-mid+1 ... Ln
            curr->next = list2;
            list2 = list2->next;
            curr->next->next = nextNode;
            curr = nextNode;
        }

        return head;
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
    soln->reorderList(testNode);

    return 0;
}
