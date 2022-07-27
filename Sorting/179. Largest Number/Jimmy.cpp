#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string largestNumber(vector<int>& nums) {
        
        string result = "";
        if (nums.size() == 0) return result;
        if (nums.size() == 1) {
            result.append(to_string(nums[0]));
            return result;
        }
        
        // bubbleSort(nums);
        // selectSort(nums);
        insertSort(nums);
        
        if (nums[0] == 0) return "0";
        
        for (int num: nums) {
            result.append(to_string(num));
        }
        
        return result;
    }
    
    bool compare(int target, int challenger) {
        string t = to_string(target);
        string c = to_string(challenger);
        
        return stol(t+c) < stol(c+t);
    }
    
    void swap(vector<int>& nums, int sourceIndex, int targetIndex) {
        int temp = nums[sourceIndex];
        nums[sourceIndex] = nums[targetIndex];
        nums[targetIndex] = temp;
    }
    
    
    void heapSort(vector<int>& nums) {
        
    }
    
    // O(n^2)
    void insertSort(vector<int>& nums) {
        int len = nums.size();
        
        // insert 會先設首個為已排好的
        for (int i = 1; i < len; i++) {
            int current = i;
            for (int j = i - 1; j >= 0; j--) {
                if (compare(nums[j], nums[current])) {
                    // swap 
                    swap(nums, j, current);
                    current = j;
                }
            }
        }
    }
    
    // O(n^2)
    void selectSort(vector<int>& nums) {
        int len = nums.size();
        
        for (int i = 0; i < len - 1; i++) {
            int current = i;
            for (int j = i + 1; j < len; j++) {
                // 用新的 index <current> 與 j index 比
                if (compare(nums[current], nums[j])) {
                     current = j;
                }
            }
            // move current to i
            swap(nums, current, i);
        }
        
        if (compare(nums[len - 2], nums[len - 1])) {
            swap(nums, len-2, len-1);
        }
    }
    
    // O(n^2)
    void bubbleSort(vector<int>& nums) {
        
        int len = nums.size();
        
        for (int i = 0; i < len; i++) {
            int current = len-1;
            for (int j = current-1; j >= i; j--) {
                if (compare(nums[j], nums[current])) {
                    swap(nums, current, j);
                }
                current = j;
            }
        }
        
        if (compare(nums[len - 2], nums[len - 1])) {
            swap(nums, len-2, len-1);
        }
    }
};