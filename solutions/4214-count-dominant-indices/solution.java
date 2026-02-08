class Solution {
    public int dominantIndices(int[] nums) {
     int n =nums.length;
        if (n<=1) return 0;
        int totalSum =0;
        for (int num : nums){
            totalSum +=num;
        }
        int dominantCount =0;
        for (int i=0; i<n-1; i++){
            totalSum -= nums[i];
            int rightCount =n-i-1;

            if (nums[i]*rightCount > totalSum){
                dominantCount++;
            }
        }
        return dominantCount;
    }
}
