class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long low =0L, high =0L;
        for (int w : weights){
            low =Math.max(low, (long) w); 
            high +=(long) w;              
        }
        while (low < high){
            long mid =low +(high - low)/2;
            if (canShip(weights, days, mid)){
                high =mid;     
            }
            else{
                low =mid +1;   
            }
        }
        return (int) low;
    }

    private boolean canShip(int[] weights, int days, long cap){
        long curr = 0L;
        int usedDays =1;
        for (int w : weights){
            if (curr + w <=cap){
                curr +=w;
            } 
            else{
                usedDays++;
                curr =w;
                if (usedDays >days) return false;
            }
        }
        return true;
    }
}

