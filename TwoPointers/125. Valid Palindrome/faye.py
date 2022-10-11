import re

class Solution:
    # space: O(1)
    # time: O(N)
    def isPalindrome(self, s):
        left = 0
        right = len(s) - 1
        while left < right:
            if not s[left].isalnum():
                left += 1
                continue                # 如果沒有跳出迴圈，左邊跟右邊指標會同時走一步，我們要的是只要跳過非英文字的字元
            if not s[right].isalnum():
                right -= 1
                continue
            if s[left].upper() != s[right].upper():
                return False
            left += 1
            right -= 1
        return True
    
    # space: O(N)
    # time: O(2N ~= N)
    def solution_2(self, s):
        s = ''.join(e for e in s if e.isalnum()).upper()
        return s == s[::-1]
    

    def solution_3(self, s):
        s = re.sub("[^a-z0-9]",'',s.lower()) # 將 a-z0-9 以外的字元取代成 ''
        return s == s[::-1]


s = "A man, a plan, a canal: Panama"
ans = Solution().solution_3(s)
print(ans)
