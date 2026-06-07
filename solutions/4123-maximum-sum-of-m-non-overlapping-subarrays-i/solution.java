class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        Object[] storedInput = {nums, m, l, r};

        int n = nums.length;

        long[] first = new long[n + 1];
        for (int i = 0; i < n; i++) {
            first[i + 1] = first[i] + nums[i];
        }

        long NEG = Long.MIN_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prev[i] = NEG;
        }

        long answer = NEG;

        for (int used = 1; used <= m; used++) {

            Arrays.fill(curr, NEG);

            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {

                int addIdx = i - l;
                if (addIdx >= 0) {
                    long val = prev[addIdx] - first[addIdx];

                    while (!dq.isEmpty()) {
                        int last = dq.peekLast();
                        long lastVal = prev[last] - first[last];
                        if (lastVal <= val) {
                            dq.pollLast();
                        } else {
                            break;
                        }
                    }
                    dq.offerLast(addIdx);
                }

                int minIdx = i - r;
                while (!dq.isEmpty() && dq.peekFirst() < minIdx) {
                    dq.pollFirst();
                }

                curr[i] = curr[i - 1];

                if (!dq.isEmpty()) {
                    int j = dq.peekFirst();
                    long candidate = first[i] + (prev[j] - first[j]);
                    curr[i] = Math.max(curr[i], candidate);
                }

                if (used == 1) {
                    long single = NEG;

                    int left = Math.max(0, i - r);
                    int right = i - l;

                    for (int j = left; j <= right; j++) {
                        single = Math.max(single, first[i] - first[j]);
                    }

                    curr[i] = Math.max(curr[i], single);
                }
            }

            answer = Math.max(answer, curr[n]);

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return answer;
        
    }
}
