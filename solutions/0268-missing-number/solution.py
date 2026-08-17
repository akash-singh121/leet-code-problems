class Solution(object):
    def missingNumber(self, nums):
        n= len(nums)
        for i in range (0, n+1):
            if i not in nums:
                return i
       
        """
        :type nums: List[int]
        :rtype: int
        """
        
