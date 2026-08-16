class Solution(object):
    def findKthLargest(self, nums, k):
        nums.sort(reverse =True)
        return nums[k-1]
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        
