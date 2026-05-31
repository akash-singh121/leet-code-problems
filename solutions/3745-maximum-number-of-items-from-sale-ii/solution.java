class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[][] array = items;

        int n = array.length;

        int cheapest = Integer.MAX_VALUE;

        int[] times = new int[n + 1];

        for (int[] it : array) {
            times[it[0]]++;
            cheapest = Math.min(cheapest, it[1]);
        }

        long[] repatation = new long[n + 1];

        for (int f = 1; f <= n; f++) {
            for (int m = f; m <= n; m += f) {
                repatation[f] += times[m];
            }
        }

        HashMap<Integer, Long> bucket = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int factor = array[i][0];
            int price = array[i][1];

            long Edges = repatation[factor] - 1L;

            if (Edges > 0) {
                bucket.merge(price, Edges, Long::sum);
            }
        }

        List<long[]> groups = new ArrayList<>();

        for (Map.Entry<Integer, Long> e : bucket.entrySet()) {
            groups.add(new long[]{e.getKey(), e.getValue()});
        }

        groups.sort((a, b) -> Long.compare(a[0], b[0]));

        long baseCopies = budget / (long) cheapest;
        long rem = budget % (long) cheapest;

        long bestExtra = 0;

        long takenUnits = 0;
        long spentCost = 0;

        bestExtra = Math.max(bestExtra,
                2L * takenUnits
                        - penalty(spentCost, rem, cheapest));

        for (long[] g : groups) {

            long price = g[0];
            long count = g[1];

            if (spentCost > budget) {
                break;
            }

            if (price < 2L * cheapest) {

                long canTake = Math.min(
                        count,
                        (budget - spentCost) / price
                );

                long endUnits = takenUnits + canTake;
                long endCost = spentCost + canTake * price;

                bestExtra = Math.max(
                        bestExtra,
                        2L * endUnits
                                - penalty(endCost, rem, cheapest)
                );
            } else {

                bestExtra = Math.max(
                        bestExtra,
                        2L * takenUnits
                                - penalty(spentCost, rem, cheapest)
                );
            }

            long usable = Math.min(
                    count,
                    Math.max(0L, (budget - spentCost) / price)
            );

            takenUnits += usable;
            spentCost += usable * price;

            if (usable < count) {
                break;
            }
        }

        long answer = baseCopies + bestExtra;

        return (int) answer;
    }

    private long penalty(long cost, long rem, long cheapest) {

        if (cost <= rem) {
            return 0;
        }

        long need = cost - rem;

        return (need + cheapest - 1) / cheapest;
        
    }
}
