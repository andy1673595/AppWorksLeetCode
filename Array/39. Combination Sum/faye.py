# 使用 DFS 來窮舉每一種組合
# Time complexity: O(N^(M/min_cand + 1)), N = len(candidates), M = target, min_cand = min(candidates)
# Space complexity: O(M/min_cand)

# 圖例
#                                                     0
#                             |-----------------------|-----------------------|
#                             0                       1                       2
#                 |-----------|-----------|        |--|--|                    |
#                 0           1           2        1     2                    2
#                 |        |--|--|        |
#                 |        1     2        2
#                 |
#     |-----------|-----------|
#     0           1           2
# |---|---|    |--|--|        |
# 0   1   2    1     2        2


class Solution:
    def combinationSum(self, candidates, target):
        ans = []
        candidate_count = len(candidates)
        def dfs(cur_elements, cur_sum, index):
            if cur_sum > target: # 如果相加大於 target 就不用再往下窮舉 提前結束遞迴
                return
            if cur_sum == target: # 如果相加等於 target 記住組合 結束遞迴
                ans.append(cur_elements)
                return
            for i in range(index, candidate_count):
                dfs(cur_elements + [candidates[i]], cur_sum + candidates[i], i)
        dfs([], 0, 0)
        return ans

candidates = [2,3,4]
target = 8

ans = Solution().combinationSum(candidates, target)