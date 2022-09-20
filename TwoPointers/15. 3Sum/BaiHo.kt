/**
Time : O(N^2)
Space: O(1)

 nums = [-4, -1, -1, 0, 2, -4]
          s   m   e ->
          ...
          <-  s   m  e -> 
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val ans = mutableSetOf<List<Int>>()
        
        for (mid in 1 .. nums.size - 2) {
            var s = 0
            var e = nums.size - 1
            
            while (s < mid && mid < e) {
                val sum = nums[s] + nums[mid] + nums[e]
                if (sum == 0) {
                    ans.add(listOf(nums[s], nums[mid], nums[e]))
                    if (s < mid-1) {
                        s ++ 
                    } else {
                        e --
                    }
                } else if (sum > 0) {
                        e --
                } else {
                        s ++
                }
            }
        }
        return ans.toList()
    }
}


/**
More efficient than above answer.

nums = [-4, -1, -1, 0, 2, -4]
         i   s   t ->
         ...
             i   s  t  ->


 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {

        nums.sort()
        
        val ans = mutableListOf<List<Int>>()

        if(nums.size <= 2) return ans

        for(i in 0..nums.size-2) {
            // if nums[i] is large than zero, sum will not be zero anymore.
            if(nums[i] > 0) break

            // The same case could be ignored.
            if(i > 0 && nums[i-1] == nums[i]) continue

            var secondIndex = i+1
            var thirdIndex = nums.size-1

            val target = -nums[i]

            while (secondIndex < thirdIndex && nums[thirdIndex] >= 0) {
               
                if(nums[secondIndex] + nums[thirdIndex] > target) {
                    thirdIndex --

                } else if (nums[secondIndex] + nums[thirdIndex] < target) {
                    secondIndex++

                } else {
                    ans.add(listOf(nums[i], nums[secondIndex], nums[thirdIndex]))
                    // Ignore the same case.
                    while (nums[secondIndex] == nums[secondIndex+1]) {
                        secondIndex++
                        if(secondIndex >= thirdIndex) break
                    }
                    while (nums[thirdIndex] == nums[thirdIndex-1]) {
                        thirdIndex--
                        if(secondIndex >= thirdIndex) break
                    }

                    secondIndex++
                    thirdIndex--
                }

            }

        }
        return ans
    }
}