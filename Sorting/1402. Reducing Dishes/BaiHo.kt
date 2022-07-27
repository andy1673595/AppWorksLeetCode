/**
Time : O(N)
Space: O(1)

Example: [-1,-8,0,5,-9]

After sorted, [5, 0, -1,-8,-9]
    sum => 5
        => 5 + (5+0)
        => 5 + (5+0) + (5+0+-1)
        ...            
 */

class Solution {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sortDescending()
        var max = 0
        var sum = 0
        var append = 0
        for (n in satisfaction) {
            append += n
            if (append < 0) return max
            sum += append
            // max = maxOf(sum, max) is more nefficient
            max = sum
        }
        return max
    }
}