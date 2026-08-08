class Solution {
    public int minOperations(int n) {
        int operation =0;
        for(int i=0; i <n/2; i++){
            operation += n-1-2*i;
        }
        return operation;
    }
}
