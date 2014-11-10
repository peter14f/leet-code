class Solution:
    # @return a tuple, (index1, index2)
    """ Please note that your returned answers (both index1 and index2)
        are not zero-based. """
    def twoSum(self, num, target):
        sorted_num = sorted(num)
        # print sorted_num
        low = 0
        high = len(num) - 1
        while low < high:
            sum = sorted_num[low] + sorted_num[high]
            # print sum
            if sum == target:
                if sorted_num[low] != sorted_num[high]:
                    index1 = num.index(sorted_num[low]) + 1 
                    index2 = num.index(sorted_num[high]) + 1
                else:
                    # must find two distinct indices 
                    first_index = num.index(sorted_num[low])
                    second_index = first_index + 1 + \
                                   num[first_index + 1:].index(sorted_num[low])
                    index1 = first_index + 1
                    index2 = second_index + 1
                 
                # requirement is that index2 must be greater than index1 
                if index1 < index2:
                    return (index1, index2)
                else:
                    return (index2, index1)
            elif sum > target:
                high -= 1
            else:
                low += 1
        return

s = Solution()

# TC 1 on LeetCode
numbers = [3, 2, 4]
target = 6
ans = s.twoSum(numbers, target)
print ans # expect (2, 3)

numbers = [0, 4, 3, 0]
target = 0
ans = s.twoSum(numbers, target)
print ans # expect (1, 4)

numbers = [-3, 4, 3, 90]
target = 0
ans = s.twoSum(numbers, target)
print ans # expect (1, 3)

numbers = [5, 75, 25]
target = 100
ans = s.twoSum(numbers, target)
print ans # expect (2, 3)
