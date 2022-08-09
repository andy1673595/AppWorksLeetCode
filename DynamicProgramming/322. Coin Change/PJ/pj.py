from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        MAX = 10001
        outputs = [0] + [MAX] * (amount)

        for index in range(1, len(outputs)):
            min_one = MAX
            for coin in coins:
                if index-coin >= 0:
                    min_one = min(min_one, outputs[index-coin]+1)
            outputs[index] = min_one
        if outputs[-1] == MAX:
            return -1
        return outputs[-1]
