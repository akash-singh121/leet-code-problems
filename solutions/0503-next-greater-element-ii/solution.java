class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        int[] result =new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> Stack = new Stack<>();
        for (int i=0; i<2*n; i++){
            int num= nums[i % n];
            while (!Stack.isEmpty() && nums[Stack.peek()] < num){
                result[Stack.pop()]= num;
            }
            if (i<n){
                Stack.push(i);
            }
        }
        return result;
        
    }
}
