class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> Stack = new Stack<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();
        for (int num : nums2){
            while (!Stack.isEmpty() && num > Stack.peek()){
                nextGreater.put(Stack.pop(), num);
            }
            Stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i =0; i<nums1.length; i++){
            result[i]= nextGreater.getOrDefault(nums1[i], -1);
        }
        return result;
        
        
    }
}
