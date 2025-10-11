class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> Stack =new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for (int i=0; i<=n; i++){
            int currHeight=(i == n) ?0:heights[i];
            while (!Stack.isEmpty() && currHeight < heights[Stack.peek()]){
                int height = heights[Stack.pop()];
                int width=Stack.isEmpty() ? i: i-Stack.peek() -1;
                maxArea =Math.max(maxArea, height*width);
            }
            Stack.push(i);
        }
        return maxArea;
        
    }

    
}
