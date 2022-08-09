/**
Time : O(NlogN * lenOfNumber)
Space: O(N) -> can reduce into O(1), just use input array to store sorted result

When we compare two elements a & b
Assume that a = "12345" , b = "789"

case.1 "12345789"
case.2 "78912345"

What we need to do is compare each char in two cases from position 0 until (a.length + b.length)
 */
class Solution {
    fun largestNumber(nums: IntArray): String {
        val list = nums.map {
            it.toString()
        }.sortedWith(comparator = object : Comparator<String> {
            override fun compare(a: String, b: String): Int {
                var i = 0
                val total = a.length + b.length
                while (i < total) {
                    val charA = if (i < a.length) {
                        a[i]
                    } else {
                        b[i-a.length]
                    }
                    val charB = if (i < b.length) {
                        b[i]
                    } else {
                        a[i-b.length]
                    }
                    // In kotlin comparator, return a nagetive number if we want to place a infront of b.
                    // Conversely, return a positive number to place a behind b.
                    // Return zero represent that they are equal.
                    if (charA != charB) return charB - charA
                    i++
                }
                return 0
            }
        })
        
        if (list.first()[0] == '0') return "0"
        return list.joinToString(separator = "")
    }
}