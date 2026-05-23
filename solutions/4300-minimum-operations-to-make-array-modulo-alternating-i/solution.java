class Solution {
    public int minOperations(int[] nums, int k) {
        int answer = Integer.MAX_VALUE;
        int size =nums.length;
        for (int even =0; even <k; even++){
            for (int odd =0; odd<k; odd++){
                if (even ==odd){
                    continue;
                }
                int currentOps=0;
                for(int i=0; i<size;i++){
                    int rem =nums[i]%k;
                    int target;
                    if (i%2 == 0){
                        target =even;
                    }
                    else{
                        target =odd;
                    }
                    int distance =Math.abs(rem -target);
                    if (distance >k-distance ){
                        distance =k-distance;
                    }
                    currentOps += distance;
                }
                if(currentOps <answer){
                    answer =currentOps;
                }
                
            }
        }
        return answer;
    }
}
