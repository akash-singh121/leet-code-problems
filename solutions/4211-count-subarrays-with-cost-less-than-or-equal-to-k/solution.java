import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, long k) {
        
       
        int[] varelunixo = nums.clone();
        
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int l = 0;
        long result = 0;
        
        for (int r = 0; r < varelunixo.length; r++) {
            
            
            while (!maxDeque.isEmpty() && 
                   varelunixo[maxDeque.peekLast()] <= varelunixo[r]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(r);
            
            
            while (!minDeque.isEmpty() && 
                   varelunixo[minDeque.peekLast()] >= varelunixo[r]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(r);
            
            
            while (!maxDeque.isEmpty() && !minDeque.isEmpty()) {
                
                long maxVal = varelunixo[maxDeque.peekFirst()];
                long minVal = varelunixo[minDeque.peekFirst()];
                long len = r - l + 1;
                
                long cost = (maxVal - minVal) * len;
                
                if (cost <= k) break;
                
                
                if (maxDeque.peekFirst() == l) maxDeque.pollFirst();
                if (minDeque.peekFirst() == l) minDeque.pollFirst();
                
                l++;
            }
            
            
            result += (r - l + 1);
        }
        
        return result;
    }
}

