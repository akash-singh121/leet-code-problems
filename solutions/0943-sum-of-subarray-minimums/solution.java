class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long mod=1_000_000_007;
        int[] left =new int[n];
        int[] right =new int[n];
        Stack<Integer> stack =new Stack<>();    
        for (int i=0; i<n; i++){
            int count =1;
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                count += left[stack.pop()];
            }
            left[i] = count;
            stack.push(i);
        }   
        stack.clear();
        for (int i=n-1; i>=0; i--){
            int count=1;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                count +=  right[stack.pop()];
            }
            right[i]=count;
            stack.push(i);
        }
        long result=0;
        for (int i=0; i<n; i++){
            long contributation =(long) arr[i]*left[i]*right[i];
            result = (result + contributation) % mod;
        }
        return (int) result;
    }
}
