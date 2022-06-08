/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2
Input: lists = []
Output: []

Example 3
Input: lists = [[]]
Output: []
*/


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

using namespace std;
#include <vector>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    // Runtime: 218 ms, faster than 22.62%
    // Memory Usage: 13.3 MB, less than 72.95%
    // TIME : O(kn)
    // SPACE : O(1)
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.size() == 0) {return nullptr;}
        if (lists.size() == 1) {return lists[0];}

        ListNode* ans = lists[0];
        for(int i = 1; i < lists.size(); i++) {
            ans = mergetTwoSortedLists(ans, lists[i]);
        }

        return ans;
    }

    //TODO: 有空測試別的方法 

private:
    ListNode* mergetTwoSortedLists(ListNode* list1, ListNode* list2) {
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
};

