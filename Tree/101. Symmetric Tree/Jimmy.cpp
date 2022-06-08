/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == NULL) return false;

        return checkSymmetricNodesIterative(root);
        // return checkSymmetricNodesRecursive(root->left, root->right);
    }

    // Time : O(n)
    // Space : O(n)
    bool checkSymmetricNodesRecursive(TreeNode* left, TreeNode *right) {
        if (left == NULL && right == NULL) return true;
        if (left == NULL || right == NULL) return false;
        if (left->val != right->val) return false;

        bool isSymmetric = checkSymmetricNodesRecursive(left->left, right->right);

        if (isSymmetric) {
            isSymmetric = checkSymmetricNodesRecursive(left->right, right->left);
        }

        return isSymmetric;

        /*
            return (left->val == right->val) &&
                        checkSymmetricNodesRecursive(left->left, right->right) &&
                        checkSymmetricNodesRecursive(left->right, right->left);

        */
    }

    /*
        想法： 將 Tree 拆成左右。並依序 left->left, right->right, left->right, right->left 放入 Stack 中。
        經由 while loop，我們不斷地讀取上面的兩個 Nodes 來看看是否相同。

        x Time : O(h) = O(log(n))
        x Space : O(1)

        我的 Time Space 應該是算錯了 ?
        Time : O(n)
        Space : O(n)

        Runtime: 8 ms, faster than 52.97%
        Memory Usage: 16.4 MB, less than 78.20%
    */
    bool checkSymmetricNodesIterative(TreeNode* root) {
        stack<TreeNode*> nodeStack;

        if (root->left == root->right) return true;

        nodeStack.push(root->left);
        nodeStack.push(root->right);

        while(!nodeStack.empty()) {
            TreeNode* right = nodeStack.top();
            nodeStack.pop();
            TreeNode* left = nodeStack.top();
            nodeStack.pop();

            if (left==NULL || right==NULL) return false;
            if (left->val != right->val) return false;

            // make sure they are not NULL
            if (left->left != right->right) {
                nodeStack.push(left->left);
                nodeStack.push(right->right);
            }

            if (left->right != right->left) {
                nodeStack.push(left->right);
                nodeStack.push(right->left);
            }
        }

        return true;
    }
};

