class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length ==0) return 0;
        int n= matrix[0].length;
        int[] heights=new int[n];
        int maxArea=0;
        for (char[] row:matrix){
            for (int j=0; j<n; j++){
                if (row[j]== '1') heights[j]++;
                else heights[j] =0;
            }
            maxArea =Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
       
    }
    private int largestRectangleArea(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        int n =heights.length;
        for (int i=0; i<=n; i++){
            int h=(i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]){
                int height =heights[stack.pop()];
                int left =stack.isEmpty() ? -1 :stack.peek();
                int width= i-left-1;
                maxArea =Math.max(maxArea, height*width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}

