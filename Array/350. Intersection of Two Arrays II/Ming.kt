/**
 * n = size of nums1, m = size of nums2
 * Time O(n+m) 
 * Space O(m) 
 */

 /**
 Follow up:
- What if the given array is already sorted? How would you optimize your algorithm?
- What if nums1's size is small compared to nums2's size? Which algorithm is better?
- What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
  */

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val tmp = IntArray(maxOf(nums1.size, nums2.size))
        var nunZeroIndex = 0
        nums1.forEach { num1 ->
            nums2.forEachIndexed { index, num2 ->
                if(num1==num2) {
                    tmp[nunZeroIndex] = num1
                    nums2[index] = Int.MIN_VALUE
                    nunZeroIndex++
                    return@forEach
                }
            }
        }

        return tmp.slice(0 until nunZeroIndex).toIntArray()
    }
}

fun main() {
    val arry1 = intArrayOf(4,7,9,7,6,7)
    val arry2 = intArrayOf(5,0,0,6,1,6,2,2,4)
    Solution350().intersect(arry1, arry2)
}