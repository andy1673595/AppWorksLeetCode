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

/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

*/

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    // Runtime: 19 ms, faster than 10.75% 
    // Memory Usage: 14.7 MB, less than 82.25%
    // 想法：用新的 ListNode 來存取新的 Nodes。
    // TIME : O(n+m)
    // SPACE : O(1)
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* mainList = nullptr;
        ListNode* curr = nullptr;

        if (list1 == nullptr) {return list2;}
        else if (list2 == nullptr) {return list1;}


        if (list1->val <= list2->val) {
            curr = list1;
            list1 = list1->next;
        } else {
            curr = list2;
            list2 = list2->next;
        }

        mainList = curr;

        while (list1 != nullptr && list2 != nullptr)
        {
            if (list1->val <= list2->val) {
                curr->next = list1;
                curr = curr->next;
                list1 = list1->next;
            } else {
                curr->next = list2;
                curr = curr->next;
                list2 = list2->next;
            }
        }

        if (list1 == nullptr) {
            curr->next = list2;
        } else {
            curr->next = list1;
        }
        
        return mainList;
    }

    // Runtime: 20 ms, faster than 8.46% 
    // Memory Usage: 14.9 MB, less than 44.26% 
    ListNode* mergeTwoListsIterateSoln(ListNode* list1, ListNode* list2) {
        ListNode* mainList = new ListNode(-1);
        ListNode *prev = mainList;

        while (list1 && list2)
        {
            if (list1->val <= list2->val) {
                prev->next = list1;
                list1 = list1->next;
            } else {
                prev->next = list2;
                list2 = list2->next;
            }

            prev = prev->next;
        }
        
        if (list1==nullptr) {prev->next = list2;}
        else {prev->next = list1;}
        
        return mainList -> next;
    }

    // Runtime: 17 ms, faster than 17.14% 
    // Memory Usage: 14.8 MB, less than 44.26%
    // TIME : O(n+m)
    // SPACE : O(n+m)
    ListNode* mergeTwoListsRecursionSoln(ListNode* list1, ListNode* list2) {
        
        if (list1 == nullptr) {
            return list2;
        } else if (list2 == nullptr) {
            return list1;
        } else if (list1->val <= list2->val) {
            list1->next = mergeTwoListsRecursionSoln(list1->next, list2);
            return list1;
        } else {
            list2->next = mergeTwoListsRecursionSoln(list1, list2->next);
            return list2;
        }
    }

};

int main(int argc, char const *argv[])
{
    ListNode *list1 = nullptr, *node = nullptr;
    for (int i = 5; i > 0; i--) {
        
        if (list1 == nullptr) {
            node = new ListNode(i);
        } else {
            node = new ListNode(i, list1);
        }

        list1 = node;
    }

    ListNode *list2 = nullptr;
    node = nullptr;
    for (int i = 7; i > 2; i--) {
        
        if (list2 == nullptr) {
            node = new ListNode(i);
        } else {
            node = new ListNode(i, list2);
        }

        list2 = node;
    }

    Solution *soln = new Solution();
    soln->mergeTwoListsIterateSoln(list1, list2);
    
    return 0;
}
