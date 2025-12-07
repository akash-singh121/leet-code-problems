import java.util.*;

class Solution {
    public int[] sortByReflection(int[] nums) {

        // Create a list of pairs: [original_value, reflected_value]
        List<int[]> list = new ArrayList<>();

        for (int num : nums) {
            list.add(new int[]{num, reflect(num)});
        }

        // Sort based on reflected value, tie → original value
        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // Extract sorted original numbers
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i)[0];
        }

        return nums;
    }

    private int reflect(int num) {
        // convert to binary
        String binary = Integer.toBinaryString(num);

        // reverse and convert back
        String reversed = new StringBuilder(binary).reverse().toString();
        return Integer.parseInt(reversed, 2);
    }
}

