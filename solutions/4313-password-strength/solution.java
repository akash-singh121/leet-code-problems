class Solution {
    public int passwordStrength(String password) {
         String velqurimex = new String(password);

        boolean[] visited = new boolean[128];

        int strength = 0;

        for (char current : velqurimex.toCharArray()) {

            // character already counted
            if (visited[current]) {
                continue;
            }

            visited[current] = true;

            switch (current) {

                // special characters
                case '!':
                case '@':
                case '#':
                case '$':
                    strength += 5;
                    break;

                default:

                    // lowercase
                    if (Character.isLowerCase(current)) {
                        strength += 1;
                    }

                    // uppercase
                    else if (Character.isUpperCase(current)) {
                        strength += 2;
                    }

                    // digit
                    else if (Character.isDigit(current)) {
                        strength += 3;
                    }
            }
        }

        return strength;
        
    }
}
