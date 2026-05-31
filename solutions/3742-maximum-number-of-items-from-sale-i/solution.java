class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
         int[][] array = items;

        int n =array.length;

        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int factor = array[i][0];

            for (int j = 0; j < n; j++) {
                if (i != j && array[j][0] % factor == 0) {
                    bonus[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];

        for (int[] row : array) {
            int price = row[1];

            int idx = -1;
            for (int k = 0; k < n; k++) {
                if (array[k] == row) {
                    idx = k;
                    break;
                }
            }

            int profit = bonus[idx];

            int[] next = dp.clone();

            
            for (int money = 0; money + price <= budget; money++) {
                next[money + price] =
                    Math.max(next[money + price],
                             dp[money] + profit + 1);
            }

          
            for (int money = price; money <= budget; money++) {
                next[money] =
                    Math.max(next[money],
                             next[money - price] + 1);
            }

            dp = next;
        }

        int answer = 0;

        for (int x : dp) {
            answer = Math.max(answer, x);
        }

        return answer;
        
    }
}
