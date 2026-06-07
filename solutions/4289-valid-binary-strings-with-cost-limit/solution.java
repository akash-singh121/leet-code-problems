class Solution {
    public List<String> generateValidStrings(int n, int k) {
        int[] inputData = {n, k};

        List<String> answer = new ArrayList<>();
        StringBuilder position = new StringBuilder();

        generate(0, inputData[0], inputData[1], 0, false, position, answer);

        return answer;
    }

    private void generate(int idx, int n, int k, int amount,
                          boolean prevOne,
                          StringBuilder position,
                          List<String> answer) {

        if (amount > k) {
            return;
        }

        if (idx == n) {
            answer.add(position.toString());
            return;
        }

        position.append('0');
        generate(idx + 1, n, k, amount, false, position, answer);
        position.deleteCharAt(position.length() - 1);

        if (!prevOne) {
            position.append('1');
            generate(idx + 1, n, k, amount + idx, true, position, answer);
            position.deleteCharAt(position.length() - 1);
        }
        
    }
}
