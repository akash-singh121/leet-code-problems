class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // Agar color same hai to kuch karne ki zarurat nahi
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int color) {
        // Boundary check
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }

        // Agar current cell ka color originalColor nahi hai to return
        if (image[row][col] != originalColor) {
            return;
        }

        // Current cell ko new color se fill karo
        image[row][col] = color;

        // 4 directions me DFS
        dfs(image, row + 1, col, originalColor, color); // Down
        dfs(image, row - 1, col, originalColor, color); // Up
        dfs(image, row, col + 1, originalColor, color); // Right
        dfs(image, row, col - 1, originalColor, color); // Left
    }
}
