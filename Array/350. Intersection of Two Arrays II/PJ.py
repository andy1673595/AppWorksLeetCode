from typing import List
from collections import defaultdict


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        buckets = defaultdict(int)
        for num1 in nums1:
            buckets[num1] += 1
        ans = []
        for num2 in nums2:
            if buckets.get(num2, 0) > 0:
                ans.append(num2)
                buckets[num2] -= 1
        return ans
