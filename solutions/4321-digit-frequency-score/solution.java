class Solution {
    public int digitFrequencyScore(int n) {
        int denoting = 0;

        for (; n != 0; n /= 10) {
            denoting += n % 10;
        }

        return denoting;
        
    }
}
