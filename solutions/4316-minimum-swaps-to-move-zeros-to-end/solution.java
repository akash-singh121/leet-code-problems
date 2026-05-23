class Solution {
    public int minimumSwaps(int[] nums) {
        int num  =nums.length;
        int zero =0;
        for (int value : nums){
            if (value ==0){
                zero++;
            }
        }
        int swap =0;
        for(int i=0; i<num -zero; i++){
            if (nums[i] == 0){
                swap++;
            }
        }
        return swap;
        
    }
}
