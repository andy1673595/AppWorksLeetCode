using namespace std;
#include <vector>

class Solution {
public:
    void sortColors(vector<int>& nums) {
        // brutalForce(nums);
        // pushTheBlocks(nums);
        // gatherZerosAndTwos(nums);
        dnfSort(nums);
    }
    
    /*
    O(m*n)
    直接先把 0 都放到前面，再將 1 放到 0 後面
    */
    void brutalForce(vector<int>& nums) {
        int lastIndex = nums.size() - 1;
        int firstIndex = 0;
        for (int i = 0; i < nums.size(); i ++) {
            // sort 0
            if (nums[i] == 0 && firstIndex != i) {
                nums[i] = nums[firstIndex];
                nums[firstIndex] = 0;
                firstIndex++;
            } else if (nums[i] == 0){
                firstIndex = i+1;
            }
        }
        
        for (int i = firstIndex; i < nums.size(); i ++) {
            // sort 1
            if (nums[i] == 1 && firstIndex != i) {
                nums[i] = nums[firstIndex];
                nums[firstIndex] = 1;
                firstIndex++;
            } else if (nums[i] == 1){
                firstIndex = i+1;
            }
        }
    }
    
    // assume nums sorted result 
    // 0 at [0...low]
    // 1 at [low+1 ... mid]
    // 2 at [mid+1 ... high]
    void pushTheBlocks(vector<int>& nums) {
        int low = -1, mid = -1, high = -1;
        for (int num: nums) {
            if (num == 0) {
                nums[++high] = 2;
                nums[++mid] = 1;
                nums[++low] = 0;
            } else if (num == 1) {
                nums[++high] = 2;
                nums[++mid] = 1;
            } else {
                nums[++high] = 2;
            }
        }
    }
    
    void gatherZerosAndTwos(vector<int>& nums) {
        int zeroIndex = 0, twosIndex = nums.size() - 1;
        
        for (int i = 0; i <= twosIndex; i++) {
            if (nums[i] == 0 && i != zeroIndex) {
                // swap 0 to front
                nums[i--] = nums[zeroIndex];
                nums[zeroIndex++] = 0;
            } else if (nums[i] == 2 && i != twosIndex) {
                // swap 2 to back
                nums[i--] = nums[twosIndex];
                nums[twosIndex--] = 2;
            }
        }
    }
    
    // Dutch National Flag problems
    // assume final result 
    //  0 at [0...low-1] 
    //  1 at [low ... mid-1]
    //  unknown at [mid ... high]
    //  2 at [high+1 ... n]
    void dnfSort(vector<int>& nums) {
        int low = 0, mid = 0, high = nums.size() - 1;
        
        while(mid <= high) {
            switch(nums[mid]) {
                case 0:
                    // swap with the low
                    nums[mid++] = nums[low];
                    nums[low++] = 0;
                    break;
                case 1:
                    mid ++;
                    break;
                case 2:
                    nums[mid] = nums[high];
                    nums[high--] = 2;
            }
        }
    }
};