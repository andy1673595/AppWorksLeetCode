/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 * Given the head of a singly linked list, return true if it is a palindrome.
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
    bool isPalindrome(ListNode* head) {
        ListNode* fast = head;
        ListNode* slow = fast;
        vector<int> values;

        // get count
        while (fast != nullptr && fast->next != nullptr)
        {
            fast = fast -> next -> next;
            values.push_back(slow->val);
            slow = slow->next;
        }

        // even amount
        if (fast != nullptr) {
            slow = slow->next;
        }

        for (int i = values.size() - 1; i >= 0; i--) {
            if (slow->val != values[i]) return false;
            slow = slow->next;
        }

        return true;
    }
};

int main(int argc, char const *argv[])
{
    ListNode *testNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

    Solution *soln = new Solution();
    soln->isPalindrome(testNode);
    

    return 0;
}