# merge sort:
#   time: O(NlogN)
#   space: O(1)
# insertion sort:
#   time: O(n2)
#   space: O(1)

class Solution:
    def largestNumber(self, nums):
        # sorted_nums = self.mergeSort(nums)
        sorted_nums = self.insertionSort(nums)
        result = str(int("".join(map(str, sorted_nums))))
        return result

    def merge(self, left, right):
        result, i, j = [], 0, 0
        while i < len(left) and j < len(right):
            if str(left[i]) + str(right[j]) > str(right[j]) + str(left[i]):
                result.append(left[i])
                i += 1
            else:
                result.append(right[j])
                j += 1
        result.extend(left[i:] or right[j:])
        return result

    def mergeSort(self, array):
        if len(array) < 2:
            return array

        mid = len(array)//2
        leftArray = array[:mid]
        rightArray = array[mid:]

        result = self.merge(self.mergeSort(leftArray), self.mergeSort(rightArray))
        return result

    def insertionSort(self, array):
        for i in range(1, len(array)):
            cur = array[i]
            j = i - 1
            while j >= 0 and str(array[j]) + str(cur) < str(cur) + str(array[j]):
                array[j + 1] = array[j]
                j -= 1
            array[j + 1] = cur
        return array

nums = [3,30,34,5,9]
result = Solution().largestNumber(nums)
print(result)
