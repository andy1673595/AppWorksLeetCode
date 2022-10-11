class Solution:
    def isAnagram(self, s, t):
        dic1, dic2 = {}, {}
        for item in s:
            dic1[item] = dic1.get(item, 0) + 1
        for item in t:
            dic2[item] = dic2.get(item, 0) + 1
        return dic1 == dic2

    def sorted_solution(self, s, t):
        return sorted(s) == sorted(t)

s = "anagram"
t = "nagaram"
ans = Solution().isAnagram(s, t)
print(ans)