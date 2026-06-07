class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int jawab = 0;

        int begin = n - k;
        if (begin < 1) {
            begin = 1;
        }

        int last = n + k;

        for (int candidate = begin; candidate <= last; candidate++) {
            if ((candidate & n) == 0) {
                jawab += candidate;
            }
        }

        return jawab;
        
    }
}
