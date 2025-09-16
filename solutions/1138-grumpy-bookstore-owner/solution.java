class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int baseline = 0;
        // baseline satisfied customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baseline += customers[i];
            }
        }

        // extra customers if we use the technique
        int extra = 0, maxExtra = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) extra += customers[i];
            if (i >= X && grumpy[i - X] == 1) extra -= customers[i - X];
            maxExtra = Math.max(maxExtra, extra);
        }

        return baseline + maxExtra;
    }
}

