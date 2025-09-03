class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int whiteCount = 0;
        
        // Count whites in first window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        int minRecolor = whiteCount;
        
        // Slide window
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') whiteCount--; // outgoing
            if (blocks.charAt(i) == 'W') whiteCount++;     // incoming
            
            minRecolor = Math.min(minRecolor, whiteCount);
        }
        
        return minRecolor;
    }
}

